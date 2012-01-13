/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.admin.service.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.providers.encoding.PasswordEncoder;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.security.dto.UserDto;

/**
 *
 * @author zaw
 */
public class UserManagementServicesImplTest {
    
    public UserManagementServicesImplTest() {
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
     * Test of getMailSenderUtil method, of class UserManagementServicesImpl.
     */
    @Test
    public void testGetMailSenderUtil() {
        System.out.println("getMailSenderUtil");
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        MailSenderUtil expResult = null;
        MailSenderUtil result = instance.getMailSenderUtil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMailSenderUtil method, of class UserManagementServicesImpl.
     */
    @Test
    public void testSetMailSenderUtil() {
        System.out.println("setMailSenderUtil");
        MailSenderUtil mailSenderUtil = null;
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        instance.setMailSenderUtil(mailSenderUtil);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManager method, of class UserManagementServicesImpl.
     */
    @Test
    public void testGetManager() {
        System.out.println("getManager");
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        Manager expResult = null;
        Manager result = instance.getManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setManager method, of class UserManagementServicesImpl.
     */
    @Test
    public void testSetManager() {
        System.out.println("setManager");
        Manager manager = null;
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        instance.setManager(manager);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSessionBean method, of class UserManagementServicesImpl.
     */
    @Test
    public void testGetSessionBean() {
        System.out.println("getSessionBean");
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        SessionBean expResult = null;
        SessionBean result = instance.getSessionBean();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSessionBean method, of class UserManagementServicesImpl.
     */
    @Test
    public void testSetSessionBean() {
        System.out.println("setSessionBean");
        SessionBean sessionBean = null;
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        instance.setSessionBean(sessionBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleListByUserLoginId method, of class UserManagementServicesImpl.
     */
    @Test
    public void testGetRoleListByUserLoginId() {
        System.out.println("getRoleListByUserLoginId");
        String userLoginId = "";
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        List expResult = null;
        List result = instance.getRoleListByUserLoginId(userLoginId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class UserManagementServicesImpl.
     */
    @Test
    public void testUpdatePassword() throws Exception {
        System.out.println("updatePassword");
        String email = "";
        String currentPassword = "";
        String newPassword = "";
        String userLoginId = "";
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        instance.updatePassword(email, currentPassword, newPassword, userLoginId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLoginIdExists method, of class UserManagementServicesImpl.
     */
    @Test
    public void testIsLoginIdExists() {
        System.out.println("isLoginIdExists");
        String loginId = "";
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        boolean expResult = false;
        boolean result = instance.isLoginIdExists(loginId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forgetPassword method, of class UserManagementServicesImpl.
     */
    @Test
    public void testForgetPassword() {
        System.out.println("forgetPassword");
        String userLoginId = "";
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        boolean expResult = false;
        boolean result = instance.forgetPassword(userLoginId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByLoginId method, of class UserManagementServicesImpl.
     */
    @Test
    public void testGetUserByLoginId() {
        System.out.println("getUserByLoginId");
        String userLoginId = "";
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        UserDto expResult = null;
        UserDto result = instance.getUserByLoginId(userLoginId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPasswordEncoder method, of class UserManagementServicesImpl.
     */
    @Test
    public void testSetPasswordEncoder() {
        System.out.println("setPasswordEncoder");
        PasswordEncoder passwordEncoder = null;
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        instance.setPasswordEncoder(passwordEncoder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasswordEncoder method, of class UserManagementServicesImpl.
     */
    @Test
    public void testGetPasswordEncoder() {
        System.out.println("getPasswordEncoder");
        UserManagementServicesImpl instance = new UserManagementServicesImpl();
        PasswordEncoder expResult = null;
        PasswordEncoder result = instance.getPasswordEncoder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
