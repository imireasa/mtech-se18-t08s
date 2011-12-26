package sg.edu.nus.iss.vms.common.web.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.member.web.controller.MemberController;

public class WelcomeController extends BaseMultiActionFormController {
	private Logger logger = Logger.getLogger(MemberController.class);

//	@Override
//	public long getLastModified(HttpServletRequest arg0) {
//		logger.debug("###################################################################################");
//		return super.getLastModified(arg0);
//	}

	public ModelAndView welcome(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		modelAndView = new ModelAndView("welcome");
		Calendar cal = Calendar.getInstance();
		int hour_of_day = cal.get(Calendar.HOUR_OF_DAY);
		if (hour_of_day < 12)
			modelAndView.addObject("message", "Good Morning");
		if (hour_of_day > 11 && hour_of_day < 17)
			modelAndView.addObject("message", "Good Afternoon");
		if (hour_of_day >= 17 && hour_of_day < 22)
			modelAndView.addObject("message", "Good Evening");
		if (hour_of_day >= 22)
			modelAndView.addObject("message", "Good Night");

		return modelAndView;
	}
}
