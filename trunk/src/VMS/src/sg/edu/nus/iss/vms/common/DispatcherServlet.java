package sg.edu.nus.iss.vms.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;

/**
 * @author zaw.htet
 * 
 */
public class DispatcherServlet extends org.springframework.web.servlet.DispatcherServlet {

	private static final long serialVersionUID = 1L;

	protected transient final Logger log = Logger.getLogger(DispatcherServlet.class);

	protected String targetInitClass = "sg.edu.nus.iss.vms.common.service.ApplicationInitializer";
	protected String targetInitMethod = "init";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.FrameworkServlet#initFrameworkServlet()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void initFrameworkServlet() throws ServletException, BeansException {
		if (log.isTraceEnabled()) {
			log.trace("start method initFrameworkServlet [" + targetInitClass + "]");
		}

		try {
			Class clazz = Class.forName(targetInitClass);
			Object target = new Object();

			try {
				Constructor constructor = clazz.getConstructor(new Class[] { DispatcherServlet.class });
				target = constructor.newInstance(this);
				log.trace("target initialize using Constructor(DispatcherServlet)");
			} catch (Exception e) {
				target = clazz.newInstance();
				log.trace("target initialize using Default Constructor()");
			}

			Method method = clazz.getMethod(targetInitMethod, (Class[]) null);
			method.invoke(target, (Object[]) null);
		} catch (ClassNotFoundException e) {
			log.warn("ClassNotFoundException : " + e);
		} catch (InstantiationException e) {
			log.warn("InstantiationException : " + e);
		} catch (IllegalAccessException e) {
			log.warn("IllegalAccessException : " + e);
		} catch (SecurityException e) {
			log.warn("SecurityException : " + e);
		} catch (NoSuchMethodException e) {
			log.warn("NoSuchMethodException : " + e);
		} catch (IllegalArgumentException e) {
			log.warn("IllegalArgumentException : " + e);
		} catch (InvocationTargetException e) {
			log.warn("InvocationTargetException : " + e);
		}

		if (log.isTraceEnabled()) {
			log.trace("end   method initFrameworkServlet [" + targetInitClass + "]");
		}
	}

	/**
	 * @return the targetInitClass
	 */
	public String getTargetInitClass() {
		return targetInitClass;
	}

	/**
	 * @param targetInitClass
	 *           the targetInitClass to set
	 */
	public void setTargetInitClass(String targetInitClassMethod) {
		this.targetInitClass = targetInitClassMethod;
	}

	/**
	 * @return the targetInitMethod
	 */
	public String getTargetInitMethod() {
		return targetInitMethod;
	}

	/**
	 * @param targetInitMethod
	 *           the targetInitMethod to set
	 */
	public void setTargetInitMethod(String targetInitMethod) {
		this.targetInitMethod = targetInitMethod;
	}
}
