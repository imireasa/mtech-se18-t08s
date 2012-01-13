package sg.edu.nus.iss.vms.reportmgmt.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GeneratePDF {
	private static Logger logger = LogManager.getLogger(GeneratePDF.class);

	public byte[] generatePDF(JasperPrint jp) {
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

	public static byte[] generatePDF(List list) {
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
