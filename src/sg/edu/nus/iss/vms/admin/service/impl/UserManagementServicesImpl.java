package sg.edu.nus.iss.vms.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.security.providers.encoding.PasswordEncoder;

import sg.edu.nus.iss.vms.admin.service.UserManagementServices;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SysConfig;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.mail.BasicMailMessage;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.RamdomPasswordGeneratorUtil;
import sg.edu.nus.iss.vms.security.dto.RoleDto;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public class UserManagementServicesImpl implements UserManagementServices {

    private Logger logger = Logger.getLogger(UserManagementServicesImpl.class);
    private Manager manager;
    private PasswordEncoder passwordEncoder;
    private MailSenderUtil mailSenderUtil;

    public MailSenderUtil getMailSenderUtil() {
        return mailSenderUtil;
    }

    public void setMailSenderUtil(MailSenderUtil mailSenderUtil) {
        this.mailSenderUtil = mailSenderUtil;
    }

    public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<RoleDto> getRoleListByUserLoginId(String userLoginId) {
        if (logger.isDebugEnabled()) {
            logger.debug("getRoleListByUserLoginId(RoleDto) - start");
        }

        List<RoleDto> roleList = null;

        try {
            String query = "SELECT role " + "FROM UserRoleDto userRole, UserDto user, RoleDto role " + "WHERE user.usrId = userRole.usrId "
                    + "AND userRole.roleId = role.roleId " + "AND user.usrLoginId = '" + userLoginId + "'";
            roleList = (List<RoleDto>) manager.find(query);
        } catch (Exception ex) {
            this.logger.error("getRoleListByUserLoginId(RoleDto) - error: ", ex);
        } finally {
            if (logger.isDebugEnabled()) {
                logger.debug("getRoleListByUserLoginId(RoleDto) - end");
            }
            return roleList;
        }
    }

    public void updatePassword(String email, String currentPassword, String newPassword, String userLoginId) throws ApplicationException {
        if (logger.isDebugEnabled()) {
            logger.debug("updatePassword(String, String, String, String) - start");
        }
        currentPassword = passwordEncoder.encodePassword(currentPassword, null);
        newPassword = passwordEncoder.encodePassword(newPassword, null);
        UserDto user = null;
        String query = "from UserDto where " + " pwd='" + currentPassword + "' " + "AND email='" + email + "' AND usrLoginId='" + userLoginId + "' AND actInd=1";
        List<UserDto> userList = manager.find(query);
        if (userList != null && !userList.isEmpty()) {
            user = userList.get(0);

        } else {
            throw new ApplicationException(Messages.getString("message.common.error.update"));
        }
        user.setPwd(newPassword);
        manager.save(user);

        if (logger.isDebugEnabled()) {
            logger.debug("updatePassword(String, String, String, String) - end");
        }
    }

    @Override
    public boolean isLoginIdExists(String loginId) {
        if (logger.isDebugEnabled()) {
            logger.debug("isLoginIdExists(String) - start");
        }

        String hQL = "from UserDto where usrLoginId='" + loginId + "'";
        List<UserDto> userList = manager.find(hQL);
        if (userList != null && !userList.isEmpty()) {
            if (logger.isDebugEnabled()) {
                logger.debug("isLoginIdExists(String) - end");
            }
            return true;
        }
        else{

        if (logger.isDebugEnabled()) {
            logger.debug("isLoginIdExists(String) - end");
        }
        return false;
        }
    }

    @Override
    public boolean forgetPassword(String userLoginId) {
        /* 1. Get Generated password
         * 2. Update the old password with generated password
         * 3. Send email to the user
         * 4. Send successful message
         */
        String generatedPwd;
        try {
            generatedPwd = RamdomPasswordGeneratorUtil.getPassword(8);
            String encoded = passwordEncoder.encodePassword(generatedPwd,null);
            
            String hQL = "from UserDto where usrLoginId='" + userLoginId + "'";
            List<UserDto> userList = manager.find(hQL);
            if (userList != null && !userList.isEmpty()) {
                UserDto user = userList.get(0);
                
                user.setPwd(encoded);
                manager.save(user);

                //To Do: send email
                try {
                    BasicMailMessage bmm = new BasicMailMessage();
                    bmm.setSubject(Messages.getString("message.volunteerManagement.welcome.email.subject"));
                    bmm.setTo(user.getEmail());

                    Map props = new HashMap();
                    props.put("FullName", user.getNme());
                    props.put("loginname", user.getUsrLoginId());
                    props.put("password", generatedPwd);
                    String url = SysConfig.getString("url.admin.view.profile");
                    props.put("UpdateProfileLink", url);

                    mailSenderUtil.send(bmm, "forgotPasswordMail.vm", props);
                } catch (Exception ex) {
                    logger.error("send mail error", ex);
                }

            }else{
                return false;
            }
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;

        }

    }

    public UserDto getUserByLoginId(String userLoginId) {

        UserDto user = null;
        String hQL = "from UserDto where usrLoginId='" + userLoginId + "'";
        List<UserDto> userList = manager.find(hQL);
        if (userList != null && !userList.isEmpty()) {
            user = userList.get(0);
        }

        return user;

    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}