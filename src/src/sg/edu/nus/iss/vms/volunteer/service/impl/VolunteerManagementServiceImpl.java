package sg.edu.nus.iss.vms.volunteer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.security.providers.encoding.PasswordEncoder;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;

import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.security.dto.RoleDto;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.security.dto.UserRoleDto;
import sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class VolunteerManagementServiceImpl implements
        VolunteerManagementService {

    private Manager manager;
    private SessionBean sessionBean;
    private Logger logger = Logger.getLogger(VolunteerManagementServiceImpl.class);
    private PasswordEncoder passwordEncoder;

    public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public SessionBean getSessionBean() {
        return this.sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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

        if (logger.isDebugEnabled()) {
            logger.debug("isLoginIdExists(String) - end");
        }
        return false;
    }

    @Override
    public void saveVolunteer(VolunteerVo volunteerVo) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("saveNewVolunteer(VolunteerVo) - start");
        }

        try {
            UserDto user = new UserDto();
            user.setUsrLoginId(volunteerVo.getLoginId());
            user.setNme(volunteerVo.getNme());
            user.setTitleCd(Long.parseLong(volunteerVo.getTitle()));
            CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
                    VMSConstants.USER_TYPE_CATEGORY,
                    VMSConstants.USER_TYPE_CATEGORY_VOLUNTEER);
            user.setTpCd(codeDto.getCdId());
            user.setEmail(volunteerVo.getEmail());
            user.setMobile(volunteerVo.getMobile());
            user.setPwd(passwordEncoder.encodePassword(volunteerVo.getPwd(),
                    null));
            user.setAddr(volunteerVo.getAddr());
            user.setPostCd(Integer.parseInt(volunteerVo.getPostCd()));
            user.setCtryCd(Long.parseLong(volunteerVo.getCtryCd()));
            user.setJoinDte(new Date());
            user.setDob(DateUtil.parseDate(volunteerVo.getDob()));
            user.setUpdBy(volunteerVo.getLoginId());
            user.setCreatedBy(volunteerVo.getLoginId());
            user.setActInd(true);


            UserDetailDto userDetail = new UserDetailDto();
            userDetail.setIntrst(volunteerVo.getIntrst());
            userDetail.setQualAtt(volunteerVo.getQualAtt());
            userDetail.setSkillSet(volunteerVo.getSkillSet());

            if (isLoginIdExists(volunteerVo.getLoginId())) {
                throw new ApplicationException(
                        Messages.getString("message.volunteerManagement.error.userDublicate"));// TODO:
                // Implement
                // Message
            }

            manager.save(user);
            userDetail.setUsrId(user);
            manager.save(userDetail);

            UserRoleDto userRoleDto = new UserRoleDto();
            userRoleDto.setUsrId(user.getUsrId());
            Long volunteerRole = CodeLookupUtil.getCodeByCatAndVal(VMSConstants.USER_ROLE, VMSConstants.USER_ROLE_VOLUNTEER).getCdId();

            String hQL = "from RoleDto where roleCd=" + volunteerRole;
            List<RoleDto> roleDtos = manager.find(hQL);
            if (roleDtos != null && !roleDtos.isEmpty()) {                
                userRoleDto.setRoleId(roleDtos.get(0));
                userRoleDto.setUpdBy(volunteerVo.getLoginId());
                userRoleDto.setCreatedBy(volunteerVo.getLoginId());
                manager.save(userRoleDto);
            } else {
                //TODO: need to rollback
                throw new ApplicationException(
                    Messages.getString("message.common.error.save"));
            }

        } catch (Exception ex) {
            logger.error("Save Volunteer", ex);
            throw new ApplicationException(
                    Messages.getString("message.common.error.save"));
        }

        if (logger.isDebugEnabled()) {
            logger.debug("saveVolunteer(VolunteerVo) - end");
        }
    }

    @Override
    public void updateVolunteer(VolunteerVo volunteerVo) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("updateVolunteer(VolunteerVo) - start");
        }

        try {
            String hQL = "from UserDto where usrLoginId = '"
                    + volunteerVo.getLoginId() + "' " + "and usrId="
                    + UserUtil.getUserSessionInfoVo().getUserSeqID();
            // assemption: only update by the login user
            List<UserDto> userList = manager.find(hQL);
            UserDto user = null;
            UserDetailDto userDetail = null;
            if (userList != null && !userList.isEmpty()) {
                user = userList.get(0);
                userDetail = user.getTbUserDetail();// TODO: Renaming
            } else {
                throw new ApplicationException(
                        Messages.getString("message.common.error.update"));
            }
            //
            user.setNme(volunteerVo.getNme());
            user.setTitleCd(Long.parseLong(volunteerVo.getTitle()));
            user.setEmail(volunteerVo.getEmail());
            user.setMobile(volunteerVo.getMobile());
            //user.setPwd(volunteerVo.getPwd());
            user.setAddr(volunteerVo.getAddr());
            user.setPostCd(Integer.parseInt(volunteerVo.getPostCd()));
            user.setCtryCd(Long.parseLong(volunteerVo.getCtryCd()));
            user.setJoinDte(new Date());
            user.setDob(DateUtil.parseDate(volunteerVo.getDob()));
            user.setCreatedBy(volunteerVo.getLoginId());// TODO: Should be login
            // user
            user.setCreatedDte(new Date());
            user.setUpdBy(volunteerVo.getLoginId());// TODO: Should be login
            // user
            user.setUpdDte(new Date());
            //
            userDetail.setIntrst(volunteerVo.getIntrst());
            userDetail.setQualAtt(volunteerVo.getQualAtt());
            userDetail.setSkillSet(volunteerVo.getSkillSet());

            manager.save(user);
            userDetail.setUsrId(user);
            manager.save(userDetail);
        } catch (Exception ex) {
            logger.error("Save Volunteer", ex);
            throw new ApplicationException(
                    Messages.getString("message.common.error.update"));
        }

        if (logger.isDebugEnabled()) {
            logger.debug("updateVolunteer(VolunteerVo) - end");
        }
    }

    @Override
    public VolunteerVo getVolunteer(String loginid) {
        if (logger.isDebugEnabled()) {
            logger.debug("getVolunteer(String) - start");
        }

        String hQL = "from UserDto where usrLoginId = '" + loginid + "'";
        List<UserDto> userList = manager.find(hQL);
        UserDto user = null;
        UserDetailDto userDetail = null;
        if (userList != null && !userList.isEmpty()) {
            user = userList.get(0);
            userDetail = user.getTbUserDetail();// TODO: Renaming
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("getVolunteer(String) - end");
            }
            return null;
        }

        VolunteerVo volunteerVo = new VolunteerVo();
        if (user != null) {
            volunteerVo.setLoginId(user.getUsrLoginId());
            volunteerVo.setTitle(Long.toString(user.getTitleCd()));
            volunteerVo.setNme(user.getNme());
            volunteerVo.setEmail(user.getEmail());
            volunteerVo.setAddr(user.getAddr());
            volunteerVo.setMobile(user.getMobile());
            volunteerVo.setPostCd(user.getPostCd() + "");
            volunteerVo.setCtryCd(user.getCtryCd() + "");
            volunteerVo.setVersion(user.getVersion() + "");
        }
        if (userDetail != null) {
            volunteerVo.setIntrst(userDetail.getIntrst());
            volunteerVo.setQualAtt(userDetail.getQualAtt());
            volunteerVo.setSkillSet(userDetail.getSkillSet());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("getVolunteer(String) - end");
        }
        return volunteerVo;
    }
}
