/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.util;

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
public class RamdomPasswordGeneratorUtilTest {
    
    public RamdomPasswordGeneratorUtilTest() {
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
     * Test of getPassword method, of class RamdomPasswordGeneratorUtil.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        int length = 0;
        String expResult = "";
        String result = RamdomPasswordGeneratorUtil.getPassword(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
