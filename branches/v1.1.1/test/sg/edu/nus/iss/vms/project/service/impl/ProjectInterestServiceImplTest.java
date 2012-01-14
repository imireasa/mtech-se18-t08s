/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.service.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestSearchVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestVo;

/**
 *
 * @author zaw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/spring-hibernate-vms.xml",
        "/spring-mail.xml",
        "/spring-resources-vms.xml",
        "/spring-security.xml",
        "/spring-service-operation.xml",
        "/spring-service.xml"
})
public class ProjectInterestServiceImplTest {

        @Qualifier("projectInterestServiceImpl")
        @Autowired
        protected ProjectInterestServiceImpl projectInterestServiceImpl;

        public ProjectInterestServiceImplTest() {
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
         * Test of getMemberManagementService method, of class ProjectInterestServiceImpl.
         */
        @Test
        public void testGetMemberManagementService() {
                System.out.println("getMemberManagementService");
                assertNotNull(projectInterestServiceImpl.getMemberManagementService());
        }

        /**
         * Test of getManager method, of class ProjectInterestServiceImpl.
         */
        @Test
        public void testGetManager() {
                System.out.println("getManager");
                assertNotNull(projectInterestServiceImpl.getManager());
        }

        /**
         * Test of updateProjectInterest method, of class ProjectInterestServiceImpl.
         */
        @Test
        public void testUpdateProjectInterest() throws Exception {
                System.out.println("updateProjectInterest");
                assertNotNull(projectInterestServiceImpl);
                ProjectInterestVo projectInterestVo = projectInterestServiceImpl.getProjectInterestbyId(1L);
                assertNotNull(projectInterestVo);
                projectInterestServiceImpl.updateProjectInterest(projectInterestVo);
        }

//        /**
//         * Test of getProjectIntrestByProjectId method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testGetProjectIntrestByProjectId() {
//                System.out.println("getProjectIntrestByProjectId");
//                Long projectId = null;
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                List expResult = null;
//                List result = instance.getProjectIntrestByProjectId(projectId);
//                assertEquals(expResult, result);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
//
//        /**
//         * Test of getProjectInterestListbyProjectIdAndUserId method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testGetProjectInterestListbyProjectIdAndUserId() {
//                System.out.println("getProjectInterestListbyProjectIdAndUserId");
//                Long prjId = null;
//                String userId = "";
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                List expResult = null;
//                List result = instance.getProjectInterestListbyProjectIdAndUserId(prjId, userId);
//                assertEquals(expResult, result);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
//
//        /**
//         * Test of getProjectInterestListByUser method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testGetProjectInterestListByUser() {
//                System.out.println("getProjectInterestListByUser");
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                List expResult = null;
//                List result = instance.getProjectInterestListByUser();
//                assertEquals(expResult, result);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
//
//        /**
//         * Test of getProjectInterestListByUserWithSearch method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testGetProjectInterestListByUserWithSearch() {
//                System.out.println("getProjectInterestListByUserWithSearch");
//                ProjectInterestSearchVo searchVo = null;
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                List expResult = null;
//                List result = instance.getProjectInterestListByUserWithSearch(searchVo);
//                assertEquals(expResult, result);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
//
//        /**
//         * Test of getProjectInterestListByUserLoginId method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testGetProjectInterestListByUserLoginId() {
//                System.out.println("getProjectInterestListByUserLoginId");
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                List expResult = null;
//                List result = instance.getProjectInterestListByUserLoginId();
//                assertEquals(expResult, result);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
//
//        /**
//         * Test of getProjectInterestbyId method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testGetProjectInterestbyId() {
//                System.out.println("getProjectInterestbyId");
//                Long id = null;
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                ProjectInterestVo expResult = null;
//                ProjectInterestVo result = instance.getProjectInterestbyId(id);
//                assertEquals(expResult, result);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
//
//        /**
//         * Test of createProjectInterest method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testCreateProjectInterest() throws Exception {
//                System.out.println("createProjectInterest");
//                ProjectInterestVo projectInterestVo = null;
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                instance.createProjectInterest(projectInterestVo);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
//
//        /**
//         * Test of getProjectInterestListBySearchCriteria method, of class ProjectInterestServiceImpl.
//         */
//        @Test
//        public void testGetProjectInterestListBySearchCriteria() {
//                System.out.println("getProjectInterestListBySearchCriteria");
//                ProjectInterestVo projectInterestVo = null;
//                ProjectInterestServiceImpl instance = new ProjectInterestServiceImpl();
//                List expResult = null;
//                List result = instance.getProjectInterestListBySearchCriteria(projectInterestVo);
//                assertEquals(expResult, result);
//                // TODO review the generated test code and remove the default call to fail.
//                fail("The test case is a prototype.");
//        }
}
