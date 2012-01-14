package sg.edu.nus.iss.vms.common.web.controller;

import java.util.ArrayList;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sg.edu.nus.iss.vms.common.orm.Manager;

public class BaseMultiActionFormController extends MultiActionController implements InitializingBean {

        protected Manager manager;
        private Logger logger = Logger.getLogger(BaseFormController.class);
        protected ModelAndView modelAndView;

        
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
        }

        public void saveError(HttpServletRequest request, String msg) {
			if (logger.isDebugEnabled()) {
				logger.debug("saveError(HttpServletRequest, String) - start");
			}

                List errorsList = (List) request.getAttribute("errors");
                if (errorsList == null) {
                        errorsList = new ArrayList();
                }
                errorsList.add(msg);
                request.setAttribute("errors", errorsList);

			if (logger.isDebugEnabled()) {
				logger.debug("saveError(HttpServletRequest, String) - errorsList size is: " + errorsList.size());
				logger.debug("saveError(HttpServletRequest, String) - end");
			}
        }
}