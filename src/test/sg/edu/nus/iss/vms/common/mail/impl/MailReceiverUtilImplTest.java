/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.mail.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zaw
 */
public class MailReceiverUtilImplTest {
    
    public MailReceiverUtilImplTest() {
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
     * Test of processMail method, of class MailReceiverUtilImpl.
     */
    @Test
    public void testProcessMail() {
        System.out.println("processMail");
        MailReceiverUtilImpl instance = new MailReceiverUtilImpl();
        instance.processMail();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
