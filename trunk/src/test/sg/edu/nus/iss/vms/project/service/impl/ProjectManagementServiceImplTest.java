/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.vms.project.service.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

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
public class ProjectManagementServiceImplTest {

    public ProjectManagementServiceImplTest() {
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
         * Test of getManager method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetManager() {
                System.out.println("getManager");
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                Manager expResult = null;
                Manager result = instance.getManager();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of setManager method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testSetManager() {
                System.out.println("setManager");
                Manager manager = null;
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                instance.setManager(manager);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getListAllProject method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetListAllProject() {
                System.out.println("getListAllProject");
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                List expResult = null;
                List result = instance.getListAllProject();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getProjectList method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectList() {
                System.out.println("getProjectList");
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                List expResult = null;
                List result = instance.getProjectList();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getProjectVoByLoginUserAccessRight method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectVoByLoginUserAccessRight() {
                System.out.println("getProjectVoByLoginUserAccessRight");
                Long projectId = null;
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                ProjectVo expResult = null;
                ProjectVo result = instance.getProjectVoByLoginUserAccessRight(projectId);
                assertEquals(expResult, result);
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
         * Test of getProjectbyId method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectbyId() {
                System.out.println("getProjectbyId");
                long id = 0L;
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                ProjectVo expResult = null;
                ProjectVo result = instance.getProjectbyId(id);
                assertEquals(expResult, result);
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
         * Test of getProjectListbyProjectVo method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectListbyProjectVo() {
                System.out.println("getProjectListbyProjectVo");
                ProjectVo projectVo = null;
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                List expResult = null;
                List result = instance.getProjectListbyProjectVo(projectVo);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getProjectMember method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectMember() {
                System.out.println("getProjectMember");
                long projectId = 0L;
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                List expResult = null;
                List result = instance.getProjectMember(projectId);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getProjectsbyProjectVo method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectsbyProjectVo() {
                System.out.println("getProjectsbyProjectVo");
                ProjectVo projectVo = null;
                ProjectManagementServiceImpl instance = new ProjectManagementServiceImpl();
                List expResult = null;
                List result = instance.getProjectsbyProjectVo(projectVo);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

}