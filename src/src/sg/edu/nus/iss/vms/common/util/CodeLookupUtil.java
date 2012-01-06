package sg.edu.nus.iss.vms.common.util;

import org.apache.log4j.Logger;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;

public class CodeLookupUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CodeLookupUtil.class);

	/**
	 * Gets the code Description based on the code ID passed in.
	 */
	public static String getCodeDescriptionByCodeId(Long codeId) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDescriptionByCodeId(Long) - start");
		}

		String codeDescription = "";
		CodeManagementServices codeMgr = getCodeManagementServices();
		codeDescription = codeMgr.getCodeDescriptionByCodeId(codeId);

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDescriptionByCodeId(Long) - end");
		}
		return codeDescription;
	}
	
	/**
	 * Gets the code Value based on the code ID passed in.
	 */
	public static String getCodeValueByCodeId(Long codeId) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeValueByCodeId(Long) - start");
		}

		String codeValue = "";
		CodeManagementServices codeMgr = getCodeManagementServices();
		codeValue = codeMgr.getCodeValueByCodeId(codeId);

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeValueByCodeId(Long) - end");
		}
		return codeValue;
	}

	/**
	 * gets the list of codes based on the category name
	 * 
	 */
	public static List<CodeDto> getListOfCodeByCategory(String category) {
		if (logger.isDebugEnabled()) {
			logger.debug("getListOfCodeByCategory(String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		List<CodeDto> returnList = codeMgr.getListOfCodeByCategory(category);
		if (logger.isDebugEnabled()) {
			logger.debug("getListOfCodeByCategory(String) - end");
		}
		return returnList;
	}

	public static CodeDto getCodeByCategoryAndCodeValue(String category,
			String value) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCategoryAndCodeValue(String, String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeDto returnCodeDto = codeMgr
				.getCodeDescriptionByCodeCategoryAndCodeDesc(category, value);
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCategoryAndCodeValue(String, String) - end");
		}
		return returnCodeDto;
	}
	
	public static CodeDto getCodeDescriptionByCodeCategoryAndCodeDesc(String category,
			String codeDesc) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDescriptionByCodeCategoryAndCodeDesc(String, String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeDto returnCodeDto = codeMgr
				.getCodeDescriptionByCodeCategoryAndCodeDesc(category, codeDesc);
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDescriptionByCodeCategoryAndCodeDesc(String, String) - end");
		}
		return returnCodeDto;
	}
	
	public static CodeDto getCodeDtoByCatVal(String category, String val) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDtoByCatVal(String, String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeDto returnCodeDto = codeMgr
				.getCodeDtoByCatVal(category, val);

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDtoByCatVal(String, String) - end");
		}
		return returnCodeDto;
	}
    
    public static CodeDto getCodeDtoByCatDesc(String category, String desc) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDtoByCatVal(String, String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeDto returnCodeDto = codeMgr
				.getCodeByCodeCategoryAndCodeDesc(category, desc);

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDtoByCatVal(String, String) - end");
		}
		return returnCodeDto;
	}
    
    
	/**
	 * @return the reference to Code management Services
	 */
	private static CodeManagementServices getCodeManagementServices() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeManagementServices() - start");
		}

		HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();
		HttpSession session = curRequest.getSession();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(session.getServletContext());
		CodeManagementServices codeMgr = (CodeManagementServices) ctx
				.getBean("codeManagementServiceImpl"); //$NON-NLS-1$

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeManagementServices() - end");
		}
		return codeMgr;
	}

}
