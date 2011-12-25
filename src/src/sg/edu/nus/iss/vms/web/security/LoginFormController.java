package sg.edu.nus.iss.vms.web.security;

import javax.servlet.ServletException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


@SuppressWarnings("deprecation")
public class LoginFormController extends SimpleFormController {
	
	@Override
	protected ModelAndView onSubmit(Object command) throws ServletException {
		LoginCommand login = (LoginCommand) command;
		String name = login.getUsername();
		String prestatement = "Hello";
		
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		modelAndView.addObject("name", name);	
		return modelAndView;
		
    }
}
