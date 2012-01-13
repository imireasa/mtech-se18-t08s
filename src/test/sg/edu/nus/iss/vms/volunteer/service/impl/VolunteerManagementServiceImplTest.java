/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.volunteer.service.impl;

import java.util.List;
import javax.activation.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

/**
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
public class VolunteerManagementServiceImplTest {

        @Qualifier("volunteerManagementServiceImpl")
        @Autowired protected VolunteerManagementService volunteerManagementService; // Injected by springy magic
        

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
//                VolunteerManagementServiceImpl instance = (VolunteerManagementService) appli;
//                Manager expResult = null;
//                Manager result = instance.getManager();
//                assertEquals(expResult, result);
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
//                SessionBean result = instance.getSessionBean();
//                assertEquals(expResult, result);
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
//                instance.setSessionBean(sessionBean);
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
//                List result = instance.getListOfMembers(projectId);
//                assertEquals(expResult, result);
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
//                List result = instance.getListOfMembers();
//                assertEquals(expResult, result);
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
//                instance.saveNewVolunteer(new VolunteerVo());
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getMailSenderUtil method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetMailSenderUtil() {
                System.out.println("getMailSenderUtil");
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                MailSenderUtil expResult = null;
                MailSenderUtil result = instance.getMailSenderUtil();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of setMailSenderUtil method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testSetMailSenderUtil() {
                System.out.println("setMailSenderUtil");
                MailSenderUtil mailSenderUtil = null;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                instance.setMailSenderUtil(mailSenderUtil);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getPasswordEncoder method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetPasswordEncoder() {
                System.out.println("getPasswordEncoder");
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                PasswordEncoder expResult = null;
                PasswordEncoder result = instance.getPasswordEncoder();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of setPasswordEncoder method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testSetPasswordEncoder() {
                System.out.println("setPasswordEncoder");
                PasswordEncoder passwordEncoder = null;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                instance.setPasswordEncoder(passwordEncoder);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of isLoginIdExists method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testIsLoginIdExists() {
                System.out.println("isLoginIdExists");
                String loginId = "";
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                boolean expResult = false;
                boolean result = instance.isLoginIdExists(loginId);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of createVolunteer method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testCreateVolunteer() throws Exception {
                System.out.println("createVolunteer");
                VolunteerVo volunteerVo = null;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                instance.createVolunteer(volunteerVo);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of updateVolunteer method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testUpdateVolunteer() throws Exception {
                System.out.println("updateVolunteer");
                VolunteerVo volunteerVo = null;
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                instance.updateVolunteer(volunteerVo);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

        /**
         * Test of getVolunteer method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetVolunteer() {
                System.out.println("getVolunteer");
                String loginid = "";
                VolunteerManagementServiceImpl instance = new VolunteerManagementServiceImpl();
                VolunteerVo expResult = null;
                VolunteerVo result = instance.getVolunteer(loginid);
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }
}
