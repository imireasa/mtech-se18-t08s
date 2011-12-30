package sg.edu.nus.iss.vms.volunteer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;

import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class VolunteerManagementServiceImpl implements VolunteerManagementService {

        private Manager manager;
        private SessionBean sessionBean;
        private Logger logger = Logger.getLogger(VolunteerManagementServiceImpl.class);

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

        @Override
        public List<ProjectMemberDto> getListOfMembers(long projectId) {
//		try{debug();}catch(Exception ex){ex.printStackTrace();}
                List<ProjectMemberDto> memberList = new ArrayList<ProjectMemberDto>();
                try {
                        this.logger.debug("@ Service Layer getting user 1");
                        String hQL = "from ProjectMember where projectId=" + projectId;
                        memberList = manager.find(hQL);
                } catch (Exception ex) {
                        this.logger.error("Data Access Error", ex);
                } finally {
                        this.logger.debug("@ Service Layer getting user 2");
                }
                return memberList;
        }

        @Override
        public List<ProjectMemberDto> getListOfMembers() {
//		try{debug();}catch(Exception ex){ex.printStackTrace();}
                List<ProjectMemberDto> userList = new ArrayList<ProjectMemberDto>();
                try {
                        this.logger.debug("@ Service Layer getting user 1");

                } catch (Exception ex) {
                        this.logger.error("Data Access Error", ex);
                } finally {
                        this.logger.debug("@ Service Layer getting user 2");
                }
                return userList;
        }

        public boolean isLoginIdExists(String loginId) {
                String hQL = "from UserDto where usrLoginId='" + loginId + "'";
                List<UserDto> userList = manager.find(hQL);
                if (userList != null && !userList.isEmpty()) {
                        return true;
                }
                return false;
        }

        @Override
        public void saveNewVolunteer(VolunteerVo volunteerVo) throws Exception {
                try {
                        UserDto user = new UserDto();
                        user.setUsrLoginId(volunteerVo.getLoginId());
                        user.setNme(volunteerVo.getNme());
                        user.setEmail(volunteerVo.getEmail());
                        user.setMobile(volunteerVo.getMobile());
                        user.setPwd(volunteerVo.getPwd());
                        user.setAddr(volunteerVo.getAddr());
                        user.setPostCd(Integer.parseInt(volunteerVo.getPostCd()));
                        user.setCtryCd(Long.parseLong(volunteerVo.getCtryCd()));
                        user.setJoinDte(new Date());
                        user.setCreatedBy(volunteerVo.getLoginId());//TODO: Should be login user
                        user.setCreatedDte(new Date());
                        user.setUpdBy(volunteerVo.getLoginId());//TODO: Should be login user
                        user.setUpdDte(new Date());
                        user.setVersion(1);
                        UserDetailDto userDetail = new UserDetailDto();

                        userDetail.setIntrst(volunteerVo.getIntrst());
                        userDetail.setQualAtt(volunteerVo.getQualAtt());
                        userDetail.setSkillSet(volunteerVo.getSkillSet());


                        if (isLoginIdExists(volunteerVo.getLoginId())) {
                                throw new ApplicationException(Messages.getString("message.volunteerManagement.error.userDublicate"));//TODO: Implement Message
                        }

                        manager.save(user);
                        userDetail.setUsrId(user);
                        manager.save(userDetail);
                } catch (Exception ex) {
                        logger.error("Save Volunteer", ex);
                        throw new ApplicationException(Messages.getString("message.common.error.save"));
                }
        }

        @Override
        public void updateVolunteer(VolunteerVo volunteerVo) throws Exception {
                try {
                        String hQL = "from UserDto where usrLoginId = '" + volunteerVo.getLoginId() + "' "
                                + "and usrId=" + UserUtil.getUserSessionInfoVo().getUserSeqID();
                        //assemption: only update by the login user
                        List<UserDto> userList = manager.find(hQL);
                        UserDto user = null;
                        UserDetailDto userDetail = null;
                        if (userList != null && !userList.isEmpty()) {
                                user = userList.get(0);
                                userDetail = user.getTbUserDetail();//TODO: Renaming
                        } else {
                                throw new ApplicationException(Messages.getString("message.common.error.update"));
                        }
                        //
                        user.setNme(volunteerVo.getNme());
                        user.setEmail(volunteerVo.getEmail());
                        user.setMobile(volunteerVo.getMobile());
                        user.setPwd(volunteerVo.getPwd());
                        user.setAddr(volunteerVo.getAddr());
                        user.setPostCd(Integer.parseInt(volunteerVo.getPostCd()));
                        user.setCtryCd(Long.parseLong(volunteerVo.getCtryCd()));
                        user.setJoinDte(new Date());
                        user.setCreatedBy(volunteerVo.getLoginId());//TODO: Should be login user
                        user.setCreatedDte(new Date());
                        user.setUpdBy(volunteerVo.getLoginId());//TODO: Should be login user
                        user.setUpdDte(new Date());
                        user.setVersion(1);
                        //
                        userDetail.setIntrst(volunteerVo.getIntrst());
                        userDetail.setQualAtt(volunteerVo.getQualAtt());
                        userDetail.setSkillSet(volunteerVo.getSkillSet());

                        manager.save(user);
                        userDetail.setUsrId(user);
                        manager.save(userDetail);
                } catch (Exception ex) {
                        logger.error("Save Volunteer", ex);
                        throw new ApplicationException(Messages.getString("message.common.error.update"));
                }
        }

        @Override
        public VolunteerVo getVolunteer(String loginid) {
                String hQL = "from UserDto where usrLoginId = '" + loginid + "'";
                List<UserDto> userList = manager.find(hQL);
                UserDto user = null;
                UserDetailDto userDetail = null;
                if (userList != null && !userList.isEmpty()) {
                        user = userList.get(0);
                        userDetail = user.getTbUserDetail();//TODO: Renaming
                } else {
                        return null;
                }

                VolunteerVo volunteerVo = new VolunteerVo();
                if (user != null) {
                        volunteerVo.setLoginId(user.getUsrLoginId());
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

                return volunteerVo;
        }
}
