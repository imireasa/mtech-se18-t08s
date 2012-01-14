package sg.edu.nus.iss.vms.reportmgmt.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;

import java.util.Properties;

import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.reportmgmt.service.ReportManagementService;

public class ReportManagementServiceImpl implements ReportManagementService {
	private Logger logger = Logger.getLogger(ReportManagementServiceImpl.class);
	private Manager manager;
	private String url;
	private String username;
	private String password;
	

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("deprecation")
	@Override
	public byte[] generatePDFReport(File reportFile,
			Map params, String queryString) throws JRException, SQLException {

		System.out.println("*******************************************************************");
		System.out.println("ReportManagementServiceImpl.generatePDFReport:"+queryString);
		System.out.println("*******************************************************************");
		JasperPrint jasperPrint;
		if (!reportFile.exists())
			throw new JRRuntimeException("File "+reportFile.getAbsolutePath()+" not found. The report design must be compiled first.");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		
		String url = this.getUrl();
		Properties props = new Properties();
		props.setProperty("user",  this.getUsername());
		props.setProperty("password",this.getPassword());
		Connection conn = DriverManager.getConnection(url, props);
		Statement stmt = conn.createStatement();
		ResultSet rs;

		rs = stmt.executeQuery(queryString);
		JRResultSetDataSource dataSource = new JRResultSetDataSource(rs);

		// Report's parameters
		Map parameters = new HashMap();
		Iterator iterator=params.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry mapEntry=(Map.Entry)iterator.next(); 
            parameters.put(mapEntry.getKey(), mapEntry.getValue());
        }
        
        // Filling the reports with data
		jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return generatePDF(jasperPrint);
	}
	
	private byte[] generatePDF(JasperPrint jp) {
		byte pdfByte[] = (byte[]) null;
		ByteArrayOutputStream byArrOutputStr = null;
		try {
			logger.info("####################### Generating PDT File[JasperPrint-1]. Please Wait ... ");
			byArrOutputStr = new ByteArrayOutputStream();
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byArrOutputStr);
			exporter.exportReport();
			pdfByte = byArrOutputStr.toByteArray();
			logger.info("***************PDF  byte[] Prepared Successfully ... OK ****************");
		} catch (JRException e) {
			logger.error("Error in creating PDF file : " + e);
		} catch (Exception e) {
			logger.error("Error in creating PDF file : " + e);
		}
		return pdfByte;
	}

	private byte[] generatePDF(List list) {
		byte pdfByte[] = (byte[]) null;
		ByteArrayOutputStream byArrOutputStr = null;
		try {
			logger.info("####################### Generating PDT File[JasperPrint-1]. Please Wait ... ");
			byArrOutputStr = new ByteArrayOutputStream();
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, list);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byArrOutputStr);
			exporter.exportReport();
			pdfByte = byArrOutputStr.toByteArray();
			logger.info("***************PDF  byte[] Prepared Successfully ... OK ****************");
		} catch (JRException e) {
			logger.error("Error in creating PDF file : " + e);
		} catch (Exception e) {
			logger.error("Error in creating PDF file : " + e);
		}
		return pdfByte;
	}

}
