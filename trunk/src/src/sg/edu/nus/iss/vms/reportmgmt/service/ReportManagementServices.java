package sg.edu.nus.iss.vms.reportmgmt.service;

import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

public interface ReportManagementServices {

//	public byte[] generateVolunteerCertificate(Long certRequestId,String reqBy,String requestType) throws JRException,SQLException;

	public byte[] generatePDFReport(String jrxmlPath,String jasperPath, Map params,String queryString) throws JRException,SQLException;
}
