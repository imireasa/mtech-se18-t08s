package sg.edu.nus.iss.vms.reportmgmt.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;

import java.util.Properties;

import javax.servlet.ServletContext;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.reportmgmt.service.ReportManagementServices;

public class ReportManagementServicesImpl implements ReportManagementServices {
	private Logger logger = Logger.getLogger(ReportManagementServicesImpl.class);
	private Manager manager;
	private SessionBean sessionBean;

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public SessionBean getSessionBean() {
		return this.sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	@Override
	public byte[] generateVolunteerCertificate(int projectId, int volunteerId) throws JRException, SQLException {

		JasperPrint jasperPrint = null;

		/*
		 * ServletContext application=getServletConfig().getServletContext();
		 * 
		 * JasperCompileManager.compileReportToFile(application.getRealPath(
		 * "/pages/reports/volunteer_certificate.jrxml")); File reportFile = new
		 * File
		 * (application.getRealPath("/pages/reports/volunteer_certificate.jasper"
		 * ));
		 */

		// Need to do to get the application path.

		JasperCompileManager.compileReportToFile("C:/volunteer_certificate.jrxml");
		File reportFile = new File("C:/volunteer_certificate.jasper");
		if (!reportFile.exists())
			throw new JRRuntimeException("File volunteer_certificate.jrxml not found. The report design must be compiled first.");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());

		// Need to do to read from properties file
		String url = "jdbc:mysql://127.0.0.1:3306/vms_prototype";
		Properties props = new Properties();
		props.setProperty("user", "root");// sys.server.database.default.username
		props.setProperty("password", "root");// sys.server.database.default.password
		Connection conn = DriverManager.getConnection(url, props);
		Statement stmt = conn.createStatement();
		ResultSet rs;

		String queryString = "SELECT p.projectName, p.ProjectStartDate,p.ProjectEndDate, CONCAT(person.FirstName,' ',person.LastName)as volunteerName";
		queryString = queryString + " FROM project p, person, project_member pm";
		queryString = queryString + " WHERE p.projectId=pm.projectId";
		queryString = queryString + " AND person.personId=pm.volunteerId";
		queryString = queryString + " AND person.personId=" + volunteerId;
		queryString = queryString + " AND p.projectId=" + projectId;
		System.out.println(queryString);
		rs = stmt.executeQuery(queryString);
		JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

		// Need to do get the organization name through hibernate (need to modify)
		String orgName = "National University of Singapore(NUS)";
		// Report's parameters
		Map parameters = new HashMap();
		parameters.put("org_name", orgName.toUpperCase());

		// Filling the reports with data
		jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return new GeneratePDF().generatePDF(jasperPrint);

	}

}
