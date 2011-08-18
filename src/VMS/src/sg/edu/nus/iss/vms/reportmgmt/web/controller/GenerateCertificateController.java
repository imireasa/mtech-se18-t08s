package sg.edu.nus.iss.vms.reportmgmt.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import sg.edu.nus.iss.vms.common.web.controller.BaseFormController;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.reportmgmt.service.CertificateManagement;
import sg.edu.nus.iss.vms.reportmgmt.service.ReportManagementServices;

public class GenerateCertificateController extends BaseMultiActionFormController {
	private Logger logger = Logger.getLogger(GenerateCertificateController.class);

	private ReportManagementServices reportManagementServicesImpl;
	private CertificateManagement certificateManagement;

	public CertificateManagement getCertificateManagement() {
		return certificateManagement;
	}

	public void setCertificateManagement(CertificateManagement certificateManagement) {
		this.certificateManagement = certificateManagement;
	}

	public ReportManagementServices getReportManagementServices() {
		return this.reportManagementServicesImpl;
	}

	public void setReportManagementServices(ReportManagementServices reportManagementServicesImpl) {
		this.reportManagementServicesImpl = reportManagementServicesImpl;
	}

	public ModelAndView generatePdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Need to do (to accept the parameter form UI)....
		// int projectId = Integer.parseInt(request.getParameter("projectId"));
		// int volunteerId =
		//Integer.parseInt(request.getParameter("volunteerId"));

		int projectId = 1;
		int volunteerId = 103;

		byte[] bytes = this.reportManagementServicesImpl.generateVolunteerCertificate(projectId, volunteerId);

		if (bytes != null && bytes.length != 0) {
			// HttpServletResponse response = (HttpServletResponse)
			// this.getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment;filename=volunteercertificate.pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outStream = response.getOutputStream();
			outStream.write(bytes, 0, bytes.length);
			outStream.flush();
			outStream.close();
		}
		// this.modelAndView.addObject("listUser", staffList);
		// this.logger.debug("Completed the request");
		return super.handleRequestInternal(request, response);
	}

	public ModelAndView generateView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Need to do (to accept the parameter form UI)....
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int volunteerId = Integer.parseInt(request.getParameter("volunteerId"));

		byte[] bytes = this.reportManagementServicesImpl.generateVolunteerCertificate(projectId, volunteerId);

		if (bytes != null && bytes.length != 0) {
			// HttpServletResponse response = (HttpServletResponse)
			// this.getExternalContext().getResponse();
			// Need to do to return the result to front end...
			// FacesContext.getCurrentInstance().responseComplete();

			response.setContentType("application/xls/csv/html/pdf/txt/html");
			response.setHeader("Content-Disposition", "attachment;filename=Report_Cert.csv");
			response.setContentLength(bytes.length);
			response.getOutputStream().write(bytes, 0, bytes.length);
			response.getOutputStream().flush();

		}
		// this.modelAndView.addObject("listUser", staffList);
		// this.logger.debug("Completed the request");
		return super.handleRequestInternal(request, response);
	}
}