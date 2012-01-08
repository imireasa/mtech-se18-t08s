package sg.edu.nus.iss.vms.web.security;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

class LogoutController implements Controller{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LogoutController.class);

	 public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
		if (logger.isDebugEnabled()) {
			logger.debug("handleRequest(HttpServletRequest, HttpServletResponse) - start"); //$NON-NLS-1$
		}

	   ModelAndView view = new ModelAndView(new RedirectView("/VMS/index.jsp"));
	   request.getSession().invalidate();

		if (logger.isDebugEnabled()) {
			logger.debug("handleRequest(HttpServletRequest, HttpServletResponse) - logged out user. HTTP session is " +request.getSession()); //$NON-NLS-1$
			logger.debug("handleRequest(HttpServletRequest, HttpServletResponse) - end"); //$NON-NLS-1$
		}
	   return view;
	 }      
	}

