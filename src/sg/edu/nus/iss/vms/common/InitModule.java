/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common;

import org.apache.log4j.Logger;

/**
 * 
 * @author zaw.htet
 */
public class InitModule {

	private Logger log = Logger.getLogger(InitModule.class);

	public void initModule() throws Exception {
		log.debug("################init##################");
	}

	public void destroy() {
		try {
			log.debug("################deInit##################");
		} catch (Exception ex) {
			log.error("Destory Init Error", ex);
		}
	}
}
