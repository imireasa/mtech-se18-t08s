package sg.edu.nus.iss.vms.common;

import java.io.Serializable;

import sg.edu.nus.iss.vms.staffmgmt.dto.Role;
import sg.edu.nus.iss.vms.staffmgmt.dto.Users;


/**
 *
 * @author zaw.htet
 */
public class SessionBean implements Serializable {

    private Users userId;
    private Role role;

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
