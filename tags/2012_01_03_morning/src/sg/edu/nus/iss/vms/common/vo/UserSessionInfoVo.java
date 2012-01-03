package sg.edu.nus.iss.vms.common.vo;

import java.sql.Timestamp;
import java.util.List;

/**
 * To store the session information after user login successful.
 * 
 * @Class name :UserSessionInfo.java
 * @author: $Author: 
 */
public class UserSessionInfoVo {

    private static final long serialVersionUID = -6963286310324191406L;;

    protected Long userSeqID = null;

    private String userID;

    private String name;

    private List<String> roles;
    
    private String email;
    
    protected String sessionID = null;

    /**
     * @return the userSeqID
     */
    public Long getUserSeqID () {
        return userSeqID;
    }

    /**
     * @param theUserSeqID the userSeqID to set
     */
    public void setUserSeqID (Long theUserSeqID) {
        this.userSeqID = theUserSeqID;
    }

    /**
     * @return the user id
     */
    public String getUserID () {
        return this.userID;
    }

    /**
     * @param theUserID the userID to set
     */
    public void setUserID (String theUserID) {
        this.userID = theUserID;
    }

    /**
     * @return the name
     */
    public String getName () {
        return name;
    }

    /**
     * @param userName the name to set
     */
    public void setName (String userName) {
        this.name = userName;
    }
    
    /**
     * @return the roles
     */
    public List<String> getRoles () {
        return roles;
    }

    /**
     * @param theRoles the roles to set
     */
    public void setRoles (List<String> theRoles) {
        this.roles = theRoles;
    }

    /**
     * Set the user's session ID.
     * 
     * @param theSessionID The user's session ID
     */
    public void setSessionID (String theSessionID) {
        this.sessionID = theSessionID;
    }
    
    /**
     * Get the user's session ID.
     * 
     * @return The user's session ID
     */
    public String getSessionID () {
        return sessionID;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
