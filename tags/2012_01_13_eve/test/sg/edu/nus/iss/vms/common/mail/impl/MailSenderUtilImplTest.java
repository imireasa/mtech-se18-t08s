/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.mail.impl;

import java.util.Map;
import org.apache.velocity.app.VelocityEngine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.vms.common.mail.BasicMailMessage;

/**
 *
 * @author zaw
 */
public class MailSenderUtilImplTest {
    
    public MailSenderUtilImplTest() {
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
     * Test of setVelocityEngine method, of class MailSenderUtilImpl.
     */
    @Test
    public void testSetVelocityEngine() {
        System.out.println("setVelocityEngine");
        VelocityEngine velocityEngine = null;
        MailSenderUtilImpl instance = new MailSenderUtilImpl();
        instance.setVelocityEngine(velocityEngine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class MailSenderUtilImpl.
     */
    @Test
    public void testSend_BasicMailMessage() {
        System.out.println("send");
        BasicMailMessage basicMessage = null;
        MailSenderUtilImpl instance = new MailSenderUtilImpl();
        instance.send(basicMessage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class MailSenderUtilImpl.
     */
    @Test
    public void testSend_BasicMailMessageArr() {
        System.out.println("send");
        BasicMailMessage[] basicMessages = null;
        MailSenderUtilImpl instance = new MailSenderUtilImpl();
        instance.send(basicMessages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class MailSenderUtilImpl.
     */
    @Test
    public void testSend_3args() {
        System.out.println("send");
        BasicMailMessage basicMessage = null;
        String templateName = "";
        Map model = null;
        MailSenderUtilImpl instance = new MailSenderUtilImpl();
        instance.send(basicMessage, templateName, model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
