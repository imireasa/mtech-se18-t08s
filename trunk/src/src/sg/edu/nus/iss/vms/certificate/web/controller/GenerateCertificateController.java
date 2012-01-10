package sg.edu.nus.iss.vms.certificate.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.certificate.service.CertificateManagementService;
import sg.edu.nus.iss.vms.certificate.vo.CertificateRequestVo;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;

public class GenerateCertificateController extends
		BaseMultiActionFormController {
	private final Logger logger = Logger
			.getLogger(GenerateCertificateController.class);

	private CertificateManagementService certificateManagementService;

	public CertificateManagementService getCertificateManagementService() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCertificateManagementService() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCertificateManagementService() - end");
		}
		return certificateManagementService;
	}

	public void setCertificateManagementService(
			CertificateManagementService certificateManagementService) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCertificateManagementService(CertificateManagementService) - start");
		}

		this.certificateManagementService = certificateManagementService;

		if (logger.isDebugEnabled()) {
			logger.debug("setCertificateManagementService(CertificateManagementService) - end");
		}
	}

	@SuppressWarnings("deprecation")
	public ModelAndView generateCertificate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - start");
		}

		modelAndView = new ModelAndView("reports/generateCertificate");
		CodeLookupVo stsRequested = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.CERTIFICATE_REQUEST_STATUS,
				VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUESTED);

		if (request.getParameter("certRequestId") == null) {

			List<CertificateRequestVo> list = certificateManagementService
					.getReqCertList(stsRequested.getCdId());

			PagedListHolder projectPagedListHolder = new PagedListHolder(list);
			if (!list.isEmpty()) {
				int page = ServletRequestUtils.getIntParameter(request, "p", 0);
				projectPagedListHolder.setPage(page);
				projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
			}
			modelAndView.addObject("pagedListHolder", projectPagedListHolder);

			modelAndView
					.addObject("certReqVoList", list);
		} else {
			// 1. change the status
			Long certReqId = Long.parseLong(request
					.getParameter("certRequestId"));
			CodeLookupVo processedSts = CodeLookupUtil.getCodeByCategoryAndCodeValue(
					VMSConstants.CERTIFICATE_REQUEST_STATUS,
					VMSConstants.CERTIFICATE_REQUEST_STATUS_PROCESSED);
			certificateManagementService.updateCertRequestStatus(certReqId,
					processedSts.getCdId());

			// 2. generate certificate
			String imagePath=request.getRealPath(VMSConstants.REPORT_CERTIFICATE_IMAGE_PATH);
			String filePath=request.getRealPath(VMSConstants.REPORT_CERTIFICATE_TEMPLATE_PATH_JASPER);

			byte[] bytes =certificateManagementService.generateCertificate(certReqId, imagePath, filePath);

			if (bytes != null && bytes.length != 0) {
				response.setContentType("application/pdf");
				response.addHeader("Content-Disposition",
						"attachment;filename= volunteer_certificate.pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream outStream = response.getOutputStream();
				outStream.write(bytes, 0, bytes.length);
				outStream.flush();
				outStream.close();

				// 3. get the remaining request list...
				List<CertificateRequestVo> list = certificateManagementService
						.getReqCertList(stsRequested.getCdId());
				modelAndView.addObject("certReqVoList",list);

				if (logger.isDebugEnabled()) {
					logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - end");
				}
				return modelAndView;
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
	}
}