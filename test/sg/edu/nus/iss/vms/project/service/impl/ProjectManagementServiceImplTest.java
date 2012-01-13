/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.service.impl;

import com.sun.net.httpserver.Authenticator.Success;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.vo.ProjectInfoVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestSearchVo;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

/**
 *
 * @author zaw
 */
public class ProjectManagementServiceImplTest {

    private ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();

    public ProjectManagementServiceImplTest() {
        Manager manager;
        SessionBean sessionBean;
        MailSenderUtil mailSenderUtil;

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMailSenderUtil method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetMailSenderUtil() {
        System.out.println("getMailSenderUtil");
        MailSenderUtil result = instance.getMailSenderUtil();
        assertEquals(instance.getMailSenderUtil(), result);
    }

    /**
     * Test of setMailSenderUtil method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testSetMailSenderUtil() {
        System.out.println("setMailSenderUtil");
//        MailSenderUtil mailSenderUtil = null;
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        instance.setMailSenderUtil(mailSenderUtil);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getManager method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetManager() {
        System.out.println("getManager");
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        Manager expResult = null;
//        Manager result = instance.getManager();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setManager method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testSetManager() {
        System.out.println("setManager");
//        Manager manager = null;
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        instance.setManager(manager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getSessionBean method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetSessionBean() {
        System.out.println("getSessionBean");
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        SessionBean expResult = null;
//        SessionBean result = instance.getSessionBean();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setSessionBean method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testSetSessionBean() {
        System.out.println("setSessionBean");
//        SessionBean sessionBean = null;
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        instance.setSessionBean(sessionBean);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfProject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetListOfProject() {
        System.out.println("getListOfProject");
//        String projectName = "";
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        List expResult = null;
//        List result = instance.getListOfProject(projectName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
//        long projectId = 0L;
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        ProjectDto expResult = null;
//        ProjectDto result = instance.getProject(projectId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectMember method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectMember_long_String() {
        System.out.println("getProjectMember");
        long projectId = 0L;
//        String memberName = "";
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        List expResult = null;
//        List result = instance.getProjectMember(projectId, memberName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getListAllProject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetListAllProject() {
        System.out.println("getListAllProject");
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        List expResult = null;
//        List result = instance.getListAllProject();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectVoByLoginUserAccessRight method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectVoByLoginUserAccessRight() {
        System.out.println("getProjectVoByLoginUserAccessRight");
        
    
    }

    /**
     * Test of getProjectIntrestVoByLoginUserAccessRight method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectIntrestVoByLoginUserAccessRight() {
        System.out.println("getProjectIntrestVoByLoginUserAccessRight");
//        Long projectId = null;
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        List expResult = null;
//        List result = instance.getProjectIntrestVoByLoginUserAccessRight(projectId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProjectMemberByProjectMemberId method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testDeleteProjectMemberByProjectMemberId() throws Exception {
        System.out.println("deleteProjectMemberByProjectMemberId");
//        String projectMemberId = "";
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        instance.deleteProjectMemberByProjectMemberId(projectMemberId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of requestProjectCertificateByProjectId method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testRequestProjectCertificateByProjectId() throws Exception {
        System.out.println("requestProjectCertificateByProjectId");
//        Long projectId = null;
//        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
//        instance.requestProjectCertificateByProjectId(projectId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProjectMemberRoleByProjectMemberIdnRole method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testUpdateProjectMemberRoleByProjectMemberIdnRole() throws Exception {
        System.out.println("updateProjectMemberRoleByProjectMemberIdnRole");
        String projectMemberId = "";
        Long roleCd = null;        
        instance.updateProjectMemberRoleByProjectMemberIdnRole(projectMemberId, roleCd);
        // TODO review the generated test code and remove the default call to fail.        
    }

    /**
     * Test of sendInviteProjectMemberToAllUser method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testSendInviteProjectMemberToAllUser() throws Exception {
        System.out.println("sendInviteProjectMemberToAllUser");
        Long projectId = null;
        Long userStatus = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        instance.sendInviteProjectMemberToAllUser(projectId, userStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acceptProjectIntrest method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testAcceptProjectIntrest() throws Exception {
        System.out.println("acceptProjectIntrest");
        Long prjIntrstId = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        instance.acceptProjectIntrest(prjIntrstId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rejectProjectIntrest method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testRejectProjectIntrest() throws Exception {
        System.out.println("rejectProjectIntrest");
        Long prjIntrstId = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        instance.rejectProjectIntrest(prjIntrstId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectbyProjectVo method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectbyProjectVo() {
        System.out.println("getProjectbyProjectVo");
        ProjectVo projectVo = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectbyProjectVo(projectVo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectObjbyId method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectObjbyId() {
        System.out.println("getProjectObjbyId");
        long id = 0L;
        Class type = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        Object expResult = null;
        Object result = instance.getProjectObjbyId(id, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectExperienceList method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectExperienceList() {
        System.out.println("getProjectExperienceList");
        ProjectDto projectDto = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectExperienceList(projectDto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of requestCertificate method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testRequestCertificate() {
        System.out.println("requestCertificate");
        CertificateRequestDto certificateRequestDto = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        instance.requestCertificate(certificateRequestDto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectVoById method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectVoById() {
        System.out.println("getProjectVoById");
        Long projectId = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        ProjectVo expResult = null;
        ProjectVo result = instance.getProjectVoById(projectId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveProject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testSaveProject() throws Exception {
        System.out.println("saveProject");
        ProjectVo projectVo = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        instance.saveProject(projectVo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testUpdateProject() throws Exception {
        System.out.println("updateProject");
        ProjectVo projectVo = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        instance.updateProject(projectVo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectFeedbackList method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectFeedbackList() {
        System.out.println("getProjectFeedbackList");
        ProjectDto projectDto = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectFeedbackList(projectDto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectFeedbackListbyVo method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectFeedbackListbyVo() {
        System.out.println("getProjectFeedbackListbyVo");
        ProjectInfoVo projectInfoVo = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectFeedbackListbyVo(projectInfoVo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectFeedbackbyId method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectFeedbackbyId() {
        System.out.println("getProjectFeedbackbyId");
        long projectFbId = 0L;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        ProjectFeedbackDto expResult = null;
        ProjectFeedbackDto result = instance.getProjectFeedbackbyId(projectFbId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrUpdateProjectObject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testSaveOrUpdateProjectObject() {
        System.out.println("saveOrUpdateProjectObject");
        Object obj = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        instance.saveOrUpdateProjectObject(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProjectObjectList method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetAllProjectObjectList() {
        System.out.println("getAllProjectObjectList");
        Class type = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getAllProjectObjectList(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectProposalListbyVo method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectProposalListbyVo() {
        System.out.println("getProjectProposalListbyVo");
        ProjectProposalVo proposalVo = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectProposalListbyVo(proposalVo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectStatusList method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectStatusList() {
        System.out.println("getProjectStatusList");
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectStatusList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listProjectbyProjectVo method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testListProjectbyProjectVo() {
        System.out.println("listProjectbyProjectVo");
        ProjectVo projectVo = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.listProjectbyProjectVo(projectVo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectInterestListbyProject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectInterestListbyProject() {
        System.out.println("getProjectInterestListbyProject");
        ProjectDto projectDto = null;
        String userId = "";
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectInterestListbyProject(projectDto, userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCertificateRequestsbyProject method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetCertificateRequestsbyProject() {
        System.out.println("getCertificateRequestsbyProject");
        Long prjId = null;
        String userId = "";
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getCertificateRequestsbyProject(prjId, userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectInterestStatusList method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectInterestStatusList() {
        System.out.println("getProjectInterestStatusList");
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectInterestStatusList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectInterestListByUser method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectInterestListByUser_0args() {
        System.out.println("getProjectInterestListByUser");
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectInterestListByUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectInterestStatusList2 method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectInterestStatusList2() {
        System.out.println("getProjectInterestStatusList2");
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectInterestStatusList2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectInterestListByUserWithSearch method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectInterestListByUserWithSearch() {
        System.out.println("getProjectInterestListByUserWithSearch");
        ProjectInterestSearchVo searchVo = null;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectInterestListByUserWithSearch(searchVo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectInterestListByUserLoginId method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectInterestListByUserLoginId() {
        System.out.println("getProjectInterestListByUserLoginId");
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectInterestListByUserLoginId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectInterestListByUser method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectInterestListByUser_Long_String() {
        System.out.println("getProjectInterestListByUser");
        Long prjId = null;
        String userId = "";
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectInterestListByUser(prjId, userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectMember method, of class ProjectManagementServiceImpl.
     */
    @Test
    public void testGetProjectMember_long() {
        System.out.println("getProjectMember");
        long projectId = 0L;
        ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
        List expResult = null;
        List result = instance.getProjectMember(projectId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
