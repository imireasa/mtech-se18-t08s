/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.staffmgmt.service.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;

/**
 *
 * @author zaw
 */
public class StaffManagementServicesImplTest {
    
    public StaffManagementServicesImplTest() {
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
     * Test of getManager method, of class StaffManagementServicesImpl.
     */
    @Test
    public void testGetManager() {
        System.out.println("getManager");
        StaffManagementServicesImpl instance = new StaffManagementServicesImpl();
        Manager expResult = null;
        Manager result = instance.getManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setManager method, of class StaffManagementServicesImpl.
     */
    @Test
    public void testSetManager() {
        System.out.println("setManager");
        Manager manager = null;
        StaffManagementServicesImpl instance = new StaffManagementServicesImpl();
        instance.setManager(manager);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSessionBean method, of class StaffManagementServicesImpl.
     */
    @Test
    public void testGetSessionBean() {
        System.out.println("getSessionBean");
        StaffManagementServicesImpl instance = new StaffManagementServicesImpl();
        SessionBean expResult = null;
        SessionBean result = instance.getSessionBean();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSessionBean method, of class StaffManagementServicesImpl.
     */
    @Test
    public void testSetSessionBean() {
        System.out.println("setSessionBean");
        SessionBean sessionBean = null;
        StaffManagementServicesImpl instance = new StaffManagementServicesImpl();
        instance.setSessionBean(sessionBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfUser method, of class StaffManagementServicesImpl.
     */
    @Test
    public void testGetListOfUser() {
        System.out.println("getListOfUser");
        StaffManagementServicesImpl instance = new StaffManagementServicesImpl();
        List expResult = null;
        List result = instance.getListOfUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
