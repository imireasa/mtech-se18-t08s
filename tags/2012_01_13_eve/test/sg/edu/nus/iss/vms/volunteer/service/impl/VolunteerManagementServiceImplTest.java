/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.volunteer.service.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

/**
 *
 * @author zaw
 */
public class VolunteerManagementServiceImplTest {

        public VolunteerManagementServiceImplTest() {
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
         * Test of getManager method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetManager() {
                System.out.println("getManager");
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                Manager expResult = null;
                Manager result = instance.getManager();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of setManager method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testSetManager() {
                System.out.println("setManager");
                Manager manager = null;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                instance.setManager(manager);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getSessionBean method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetSessionBean() {
                System.out.println("getSessionBean");
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                SessionBean expResult = null;
                SessionBean result = instance.getSessionBean();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of setSessionBean method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testSetSessionBean() {
                System.out.println("setSessionBean");
                SessionBean sessionBean = null;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                instance.setSessionBean(sessionBean);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getListOfMembers method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetListOfMembers_long() {
                System.out.println("getListOfMembers");
                long projectId = 0L;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                List expResult = null;
                List result = instance.getListOfMembers(projectId);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getListOfMembers method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetListOfMembers_0args() {
                System.out.println("getListOfMembers");
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                List expResult = null;
                List result = instance.getListOfMembers();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of saveNewVolunteer method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testSaveNewVolunteer() throws Exception {
                System.out.println("saveNewVolunteer");
                UserDto user = null;
                UserDetailDto userDetail = null;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                instance.saveNewVolunteer(new VolunteerVo());
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }
}
