package sg.edu.nus.iss.vms.common.web.controller;

import java.util.ArrayList;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;

public class BaseMultiActionFormController extends MultiActionController implements InitializingBean {

        protected Manager manager;
        protected SessionBean sessionBean;
        private Logger log = Logger.getLogger(BaseFormController.class);
        protected ModelAndView modelAndView;

        public void setSessionBean(SessionBean sessionBean) {
                this.sessionBean = sessionBean;
        }

        public void setManager(Manager manager) {
                this.manager = manager;
        }

        public ModelAndView getModelAndView() {
                return modelAndView;
        }

        public void setModelAndView(ModelAndView modelAndView) {
                this.modelAndView = modelAndView;
        }

        public void afterPropertiesSet() throws Exception {
                if (this.manager == null) {
                        setManager((Manager) getApplicationContext().getBean("baseManager"));
                }
                if (this.sessionBean == null) {
                        setSessionBean((SessionBean) getApplicationContext().getBean("sessionBean"));
                }
        }

        public void saveError(HttpServletRequest request, String msg) {
                List errorsList = (List) request.getAttribute("errors");
                if (errorsList == null) {
                        errorsList = new ArrayList();
                }
                errorsList.add(msg);
                request.setAttribute("errors", errorsList);
        }
}