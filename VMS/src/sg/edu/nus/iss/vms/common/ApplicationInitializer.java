package sg.edu.nus.iss.vms.common;

import org.apache.log4j.Logger;

/**
 * @author zaw.htet
 * 
 */
public class ApplicationInitializer {

	protected final Logger log = Logger.getLogger(ApplicationInitializer.class);
	protected DispatcherServlet dispatcherServlet = null;

	public ApplicationInitializer(DispatcherServlet dispatcherServlet) {
		this.dispatcherServlet = dispatcherServlet;
	}

	public void init() {
		// TODO define method in this method
		initGroupModules();
	}

	protected void initGroupModules() {
		log.trace("start init GroupModules");
		log.trace("dispatcherServlet=" + dispatcherServlet);
		log.trace("end   init GroupModules");
	}
}
