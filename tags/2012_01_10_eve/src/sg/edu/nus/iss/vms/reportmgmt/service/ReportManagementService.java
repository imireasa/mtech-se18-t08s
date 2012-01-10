package sg.edu.nus.iss.vms.reportmgmt.service;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;



public interface ReportManagementService {

//	public byte[] generateVolunteerCertificate(Long certRequestId,String reqBy,String requestType) throws JRException,SQLException;

	public byte[] generatePDFReport(File reportFile, Map params,String queryString) throws JRException,SQLException;
}
