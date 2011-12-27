/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.web.controller;

import java.util.Iterator;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.util.WebUtils;

/**
 *
 * @author zaw
 */
public class SubmitParameterPropertiesMethodNameResolver implements
          MethodNameResolver {

        private String defaultMethodName;
        private Properties mappings;
        private Logger logger = Logger.getLogger(this.getClass());

        /**
         * Set URL to method name mappings from a Properties object.
         * @param mappings properties with URL as key and method name as value
         */
        public void setMappings(Properties mappings) {
                this.mappings = mappings;
        }

        /**
         * @param defaultMethodName The defaultMethodName to set.
         */
        public void setDefaultMethodName(String defaultMethodName) {
                //logger.info("setting defaultMethod:"+defaultMethodName);
                this.defaultMethodName = defaultMethodName;
        }

        public void afterPropertiesSet() {
                if (this.mappings == null || this.mappings.isEmpty()) {
                        throw new IllegalArgumentException("'mappings' property is required");
                }
        }

        public String getHandlerMethodName(HttpServletRequest request)
                  throws NoSuchRequestHandlingMethodException {

                for (Iterator it = this.mappings.keySet().iterator(); it.hasNext();) {
                        String submitParamter = (String) it.next();
                        //logger.info("getHandlerMethodName:"+submitParamter);
                        if (WebUtils.hasSubmitParameter(request, submitParamter)) {
                                return (String) this.mappings.get(submitParamter);
                        }
                }
                logger.info("returning defaultMethodName");
                return defaultMethodName;
        }
}