/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.reportmgmt.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.reportmgmt.service.CertificateManagement;
import sg.edu.nus.iss.vms.reportmgmt.service.ReportManagementService;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;

/**
 *
 * @author zaw
 */
public class GenerateCertificateControllerTest {
    
    public GenerateCertificateControllerTest() {
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
     * Test of getCodeManagementServices method, of class GenerateCertificateController.
     */
    @Test
    public void testGetCodeManagementServices() {
        System.out.println("getCodeManagementServices");
        GenerateCertificateController instance = new GenerateCertificateController();
        CodeManagementServices expResult = null;
        CodeManagementServices result = instance.getCodeManagementServices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodeManagementServices method, of class GenerateCertificateController.
     */
    @Test
    public void testSetCodeManagementServices() {
        System.out.println("setCodeManagementServices");
        CodeManagementServices codeManagementServices = null;
        GenerateCertificateController instance = new GenerateCertificateController();
        instance.setCodeManagementServices(codeManagementServices);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolunteerManagementService method, of class GenerateCertificateController.
     */
    @Test
    public void testGetVolunteerManagementService() {
        System.out.println("getVolunteerManagementService");
        GenerateCertificateController instance = new GenerateCertificateController();
        VolunteerManagementService expResult = null;
        VolunteerManagementService result = instance.getVolunteerManagementService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVolunteerManagementService method, of class GenerateCertificateController.
     */
    @Test
    public void testSetVolunteerManagementService() {
        System.out.println("setVolunteerManagementService");
        VolunteerManagementService volunteerManagementService = null;
        GenerateCertificateController instance = new GenerateCertificateController();
        instance.setVolunteerManagementService(volunteerManagementService);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectManagementService method, of class GenerateCertificateController.
     */
    @Test
    public void testGetProjectManagementService() {
        System.out.println("getProjectManagementService");
        GenerateCertificateController instance = new GenerateCertificateController();
        ProjectManagementService expResult = null;
        ProjectManagementService result = instance.getProjectManagementService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjectManagementService method, of class GenerateCertificateController.
     */
    @Test
    public void testSetProjectManagementService() {
        System.out.println("setProjectManagementService");
        ProjectManagementService projectManagementService = null;
        GenerateCertificateController instance = new GenerateCertificateController();
        instance.setProjectManagementService(projectManagementService);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCertificateManagement method, of class GenerateCertificateController.
     */
    @Test
    public void testGetCertificateManagement() {
        System.out.println("getCertificateManagement");
        GenerateCertificateController instance = new GenerateCertificateController();
        CertificateManagement expResult = null;
        CertificateManagement result = instance.getCertificateManagement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCertificateManagement method, of class GenerateCertificateController.
     */
    @Test
    public void testSetCertificateManagement() {
        System.out.println("setCertificateManagement");
        CertificateManagement certificateManagement = null;
        GenerateCertificateController instance = new GenerateCertificateController();
        instance.setCertificateManagement(certificateManagement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReportManagementServices method, of class GenerateCertificateController.
     */
    @Test
    public void testGetReportManagementService() {
        System.out.println("getReportManagementService");
        GenerateCertificateController instance = new GenerateCertificateController();
        ReportManagementService expResult = null;
        ReportManagementService result = instance.getReportManagementService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReportManagementServices method, of class GenerateCertificateController.
     */
    @Test
    public void testSetReportManagementService() {
        System.out.println("setReportManagementService");
        ReportManagementService reportManagementServiceImpl = null;
        GenerateCertificateController instance = new GenerateCertificateController();
        instance.setReportManagementService(reportManagementServiceImpl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateCertificate method, of class GenerateCertificateController.
     */
    @Test
    public void testGenerateCertificate() throws Exception {
        System.out.println("generateCertificate");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        GenerateCertificateController instance = new GenerateCertificateController();
        ModelAndView expResult = null;
        ModelAndView result = instance.generateCertificate(request, response);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
