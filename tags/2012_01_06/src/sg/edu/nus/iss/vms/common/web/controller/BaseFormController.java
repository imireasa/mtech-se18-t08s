package sg.edu.nus.iss.vms.common.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.CancellableFormController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;

/**
 * 
 * @author zaw.htet
 */
// CancellableFormController
public class BaseFormController extends CancellableFormController implements InitializingBean {

	protected Manager manager;
	protected SessionBean sessionBean;

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	private Logger log = Logger.getLogger(BaseFormController.class);
	protected ModelAndView modelAndView;

	public ModelAndView getModelAndView() {
		return modelAndView;
	}

	public void setModelAndView(ModelAndView modelAndView) {
		this.modelAndView = modelAndView;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// if (sessionBean.getPerson() == null) {
		// modelAndView = new ModelAndView("noSession");
		// } else {
		// UserRole userrole = (UserRole) manager.get(UserRole.class,
		// sessionBean.getUserId());
		//
		// if (modelAndView == null) {
		// log.debug("model and view obj is null");
		// }

		// modelAndView.addObject("username",
		// sessionBean.getUserId().getUserName());
		// modelAndView.addObject("person", sessionBean.getPerson());
		// }
		return modelAndView;
	}

	public void afterPropertiesSet() throws Exception {

		if (this.manager == null) {
			setManager((Manager) getApplicationContext().getBean("baseManager"));
		}
		if (this.sessionBean == null) {
			setSessionBean((SessionBean) getApplicationContext().getBean("sessionBean"));
		}
		if (modelAndView == null) {
			setModelAndView(new ModelAndView(getFormView()));
		}
	}
}
