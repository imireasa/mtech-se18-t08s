/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.web.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 *
 * @author zaw
 */
public class SimpleMultiActionFormController extends SimpleFormController {

        private MethodNameResolver methodNameResolver = new SubmitParameterPropertiesMethodNameResolver();
        private Logger logger = Logger.getLogger(SimpleMultiActionFormController.class);

        public final void setMethodNameResolver(MethodNameResolver methodNameResolver) {
                this.methodNameResolver = methodNameResolver;
        }

        public final MethodNameResolver getMethodNameResolver() {
                return this.methodNameResolver;
        }

        protected ModelAndView processFormSubmission(HttpServletRequest request,
                  HttpServletResponse response, Object command, BindException errors)
                  throws Exception {

                ServletRequestDataBinder binder = createBinder(request, command);
                binder.bind(request);


                if (errors.hasErrors() || isFormChangeRequest(request)) {
                        if (logger.isDebugEnabled()) {
                                logger.info("Data binding errors: " + errors.getErrorCount());
                        }
                        logger.info("error is:" + errors.getFieldValue(request.getAttribute("file0").toString()));
                        logger.info("error is:" + errors.getNestedPath());

                        return showForm(request, response, errors);
                } else {
                        String methodName = this.methodNameResolver.getHandlerMethodName(request);

                        Method m = (Method) this.getClass().getMethod(methodName,
                                  new Class[]{HttpServletRequest.class, HttpServletResponse.class,
                                          Object.class, BindException.class});
                        if (m == null) {
                                throw new NoSuchRequestHandlingMethodException(methodName, getClass());
                        }

                        List params = new ArrayList(4);
                        params.add(request);
                        params.add(response);
                        params.add(command);
                        params.add(errors);

                        return (ModelAndView) m.invoke(this, params.toArray(new Object[params.size()]));
                        //return null;
                }
        }
}