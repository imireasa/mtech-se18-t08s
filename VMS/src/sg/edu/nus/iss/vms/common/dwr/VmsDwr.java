/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dwr;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.orm.Manager;

/**
 *
 * @author Jay
 */
public class VmsDwr {

    private Logger log = Logger.getLogger(VmsDwr.class);
    private Manager manager;
    
    /**
     * @return the log
     */
    public Logger getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(Logger log) {
        this.log = log;
    }

    /**
     * @return the manager
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
