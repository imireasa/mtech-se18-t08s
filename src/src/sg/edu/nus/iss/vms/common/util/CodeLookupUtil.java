package sg.edu.nus.iss.vms.common.util;

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
	 * Gets the code Description based on the code ID passed in.
	 */
	public static String getCodeDescriptionByCodeId(Long codeId) {
		String codeDescription = "";
		CodeManagementServices codeMgr = getCodeManagementServices();
		codeMgr.getCodeDescriptionByCodeId(codeId);
		return codeDescription;
	}

	
	/**
	 * gets the list of codes based on the category name
	 * 
	 */
	public static List <CodeDto> getListOfCodeByCategory(String category){
		CodeManagementServices codeMgr = getCodeManagementServices();
		return codeMgr.getListOfCodeByCategory(category);
	}
	
	
	/**
	 * @return the reference to Code management Services
	 */
	private static CodeManagementServices getCodeManagementServices() {
		HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = curRequest.getSession();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		CodeManagementServices codeMgr = (CodeManagementServices) ctx.getBean("codeManagementServiceImpl"); //$NON-NLS-1$
		return codeMgr;
	}

}
