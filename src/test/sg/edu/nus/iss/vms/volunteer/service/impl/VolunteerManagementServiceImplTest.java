/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.volunteer.service.impl;

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
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

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
public class VolunteerManagementServiceImplTest {

        @Qualifier("volunteerManagementServiceImpl")
        @Autowired
        protected VolunteerManagementServiceImpl volunteerManagementService;

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
         * Test of getMailSenderUtil method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetMailSenderUtil() {
                System.out.println("getMailSenderUtil");
                assertNotNull(volunteerManagementService.getMailSenderUtil());
        }

        /**
         * Test of getManager method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetManager() {
                System.out.println("getManager");
                assertNotNull(volunteerManagementService.getManager());
        }

        /**
         * Test of getPasswordEncoder method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetPasswordEncoder() {
                System.out.println("getPasswordEncoder");
                assertNotNull(volunteerManagementService.getPasswordEncoder());
        }

        /**
         * Test of isLoginIdExists method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testIsLoginIdExists() {
                System.out.println("isLoginIdExists");
                assertTrue(volunteerManagementService.isLoginIdExists("Alana59"));
                assertFalse(volunteerManagementService.isLoginIdExists("!@#$%^&*"));
        }

        /**
         * Test of createVolunteer method, of class VolunteerManagementServiceImpl.
         */
//        @Test
//        public void testCreateVolunteer() throws Exception {
//                System.out.println("createVolunteer");
//                try {
//                        VolunteerVo vo = new VolunteerVo();
//                        vo.setNme("1234567890");
//                        vo.setAddr("1234567890");
//                        vo.setCfpwd("1234567890");
//                        vo.setCmdType("1234567890");
//                        vo.setCtryCd("1234567890");
//                        vo.setDob("1234567890");
//                        vo.setEmail("1234567890");
//                        vo.setIntrst("1234567890");
//                        vo.setLoginId("1234567890");
//                        vo.setMobile("1234567890");
//                        vo.setNme("1234567890");
//                        vo.setPostCd("1234567890");
//                        vo.setPwd("1234567890");
//                        vo.setQualAtt("1234567890");
//                        vo.setSkillSet("1234567890");
//                        vo.setTitle("1234567890");
//                        volunteerManagementService.createVolunteer(vo);
//                } catch (Exception ex) {
//                        fail("volunteer not a correct format");
//                }
//
//                try {
//                        VolunteerVo vo = new VolunteerVo();
//                        vo.setLoginId("1234567890");
//                        vo.setNme("1234567890");
//                        vo.setAddr("1234567890");
//                        vo.setPwd("123");
//                        vo.setCfpwd("123");
//                        vo.setCtryCd("1");
//                        vo.setDob("10-10-2011");
//                        vo.setEmail("zwhtet@gmail.com");
//                        vo.setIntrst("1");
//
//                        vo.setMobile("1234567890");
//                        vo.setNme("1234567890");
//                        vo.setPostCd("1234567890");
//                        vo.setQualAtt("1234567890");
//                        vo.setSkillSet("1234567890");
//                        vo.setTitle("1");
//                        volunteerManagementService.createVolunteer(vo);
//                } catch (Exception ex) {
//                        fail("volunteer not a correct format" + ex.getMessage());
//                }
//
//                try {
//                        volunteerManagementService.createVolunteer(null);
//                        fail("null volunteer created");
//                } catch (Exception ex) {
//                }
//
//        }

        /**
         * Test of updateVolunteer method, of class VolunteerManagementServiceImpl.
         */
        @Test
        public void testGetVolunteer() throws Exception {
                System.out.println("updateVolunteer");
                

                try {
                        VolunteerVo vo = volunteerManagementService.getVolunteer("Alana59");
                        assertEquals(vo.getNme(), "Dio Phung");                        
                } catch (Exception ex) {
                        fail(ex.getMessage());
                }
        }
}
