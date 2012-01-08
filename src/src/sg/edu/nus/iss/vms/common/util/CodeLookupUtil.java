package sg.edu.nus.iss.vms.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;

public class CodeLookupUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CodeLookupUtil.class);

	/**
	 * Returns the code description based on the code Id.
	 * 
	 * @param codeId - the code Id
	 * @return the code description.
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
	 * Returns the code value based on the code Id.
	 * 
	 * @param codeId - the code Id
	 * @return the code value.
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
	 * Returns a list of codes based on the category name.
	 * 
	 * @param category - the category name to retrieve the list of corresponding code value.
	 * @return a list of CodeLookupVo
	 */
	public static List<CodeDto> getCodeListByCategory(String category) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeListByCategory(String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		List<CodeDto> returnList = codeMgr.getCodeListByCategory(category);
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeListByCategory(String) - end");
		}
		return returnList;
	}

	/**
	 * Returns a code object based on the category name and code value.
	 * 
	 * @param category - the category name to retrieve the code object.
	 * @param value - the value to retrieve the code object.
	 * @return a CodeLookupVo object
	 */
	public static CodeLookupVo getCodeByCategoryAndCodeValue(String category,
			String value) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCategoryAndCodeValue(String, String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeLookupVo codeLookupVo = codeMgr
				.getCodeByCategoryAndCodeValue(category, value);
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCategoryAndCodeValue(String, String) - end");
		}
		return codeLookupVo;
	}

	/*public static CodeDto getCodeDescriptionByCodeCategoryAndCodeDesc(
			String category, String codeDesc) {
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
	}*/

	/*public static CodeDto getCodeByCatAndVal(String category, String val) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCatAndVal(String, String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeDto returnCodeDto = codeMgr.getCodeByCategoryAndCodeValue(category, val);

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCatAndVal(String, String) - end");
		}
		return returnCodeDto;
	}*/

	/*public static CodeDto getCodeDtoByCatDesc(String category, String desc) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDtoByCatVal(String, String) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeDto returnCodeDto = codeMgr.getCodeByCodeCategoryAndCodeDesc(
				category, desc);

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDtoByCatVal(String, String) - end");
		}
		return returnCodeDto;
	}*/

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

	/**
	 * Returns a code object based on the code Id.
	 * 
	 * @param id - the code id.
	 * @return a CodeLookupVo object
	 */
	public static CodeLookupVo getCodeById(Long id) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeById(Long) - start");
		}

		CodeManagementServices codeMgr = getCodeManagementServices();
		CodeLookupVo codeLookupVo = codeMgr.getCodeById(id);

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeById(String, String) - end");
		}
		return codeLookupVo;
	}

}
