package sg.edu.nus.iss.vms.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.security.service.SecurityManagementService;

public class AuthorisationFilter implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AuthorisationFilter.class);

	private String errorPage;
	private String loginPage;
	private String unauthorisedPage;
	private List excludePages;
	private Boolean isAuthorisationFilterEnabled;

	/** Filter should be configured with an system error page. */
	public void init(FilterConfig FilterConfig) throws ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("init(FilterConfig) - start"); //$NON-NLS-1$
		}

		if (FilterConfig != null) {
			errorPage = FilterConfig.getInitParameter(Messages.getString("AuthorisationFilter.FILTER_ERROR_PAGE_LOCATION")); //$NON-NLS-1$
			loginPage = FilterConfig.getInitParameter(Messages.getString("AuthorisationFilter.FILTER_LOGIN_PAGE_LOCATION")); //$NON-NLS-1$
			unauthorisedPage = FilterConfig.getInitParameter(Messages.getString("AuthorisationFilter.FILTER_UNAUTHORISED_PAGE_LOCATION")); //$NON-NLS-1$
			String excludePageString = FilterConfig.getInitParameter(Messages.getString("AuthorisationFilter.AUTHORISATION_EXCLUDED_PAGES_ATTR_NME"));//$NON-NLS-1$
			StringTokenizer st = new StringTokenizer(excludePageString, ",");
			excludePages = new ArrayList();
			while (st.hasMoreTokens()) {
				excludePages.add((String) st.nextToken());
			}
			String authorisationFlag = FilterConfig.getInitParameter(Messages.getString("AuthorisationFilter.AUTHORISATION_ENABLED_ATTR_NME"));//$NON-NLS-1$
			isAuthorisationFilterEnabled = new Boolean(authorisationFlag);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("init(FilterConfig) - end"); //$NON-NLS-1$
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - start"); //$NON-NLS-1$
		}
		String URI = ((HttpServletRequest) request).getRequestURI();

		if (logger.isDebugEnabled()) {
			logger
					.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - Requesting for Access to URI - excludePages=" + excludePages + ", isAuthorisationFilterEnabled=" + isAuthorisationFilterEnabled + ", URI=" + URI); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		// check if authorisation is enabled
		if (!isAuthorisationFilterEnabled) {
			chain.doFilter(request, response);
			return;
		}
		// check if routing to excluded pages
		for (int i = 0; i < excludePages.size(); i++) {
			if (URI.equals((String) excludePages.get(i))) {
				// if excluded, carry on
				if (logger.isDebugEnabled()) {
					logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - excluded page hit."); //$NON-NLS-1$
				}
				chain.doFilter(request, response);
				return;
			}
		}
		// else check for user rights to the page
		if (errorPage == null) {
			returnError(request, response, Messages.getString("AuthorisationFilter.AUTH_FILTER_LOAD_ERROR"), errorPage); //$NON-NLS-1$
		}
		UserDto currentUser = null;
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session != null) {
			currentUser = (UserDto) session.getAttribute(Messages.getString("AuthorisationFilter.SESSION_USER_ATTR_NME")); //$NON-NLS-1$
		}
		if (currentUser == null) {
			returnError(request, response, Messages.getString("AuthorisationFilter.USER_NOT_IN_SESSION_ERROR"), loginPage); //$NON-NLS-1$
			return;
		}
		else {
			// Get relevant URI.

			// Obtain AuthorisationManager singleton from Spring
			// ApplicationContext.
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
			SecurityManagementService authMgr = (SecurityManagementService) ctx.getBean("SecurityManagementServiceImpl"); //$NON-NLS-1$

			// Invoke AuthorisationManager method to see if user can
			// access resource.
			boolean authorised = authMgr.isUserAuthorised(currentUser, URI);
			if (authorised) {
				chain.doFilter(request, response);
				return;
			}
			else {
				returnError(request, response, Messages.getString("AuthorisationFilter.USER_UNAUTHORISED"), unauthorisedPage); //$NON-NLS-1$
				if (logger.isDebugEnabled()) {
					logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
				}
				return;
			}
		}

		
	}

	private void returnError(ServletRequest request, ServletResponse response, String errorString, String redirectPage) throws ServletException,
			IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("returnError(ServletRequest, ServletResponse, String) - start"); //$NON-NLS-1$
		}

		request.setAttribute(Messages.getString("AuthorisationFilter.RESPONSE_ERROR_ATTR_NME"), errorString); //$NON-NLS-1$
		request.getRequestDispatcher(redirectPage).forward(request, response);

		if (logger.isDebugEnabled()) {
			logger.debug("returnError(ServletRequest, ServletResponse, String) - end"); //$NON-NLS-1$
		}
	}

	@Override
	public void destroy() {
		// TOdDO Auto-generated method stub

	}
}
