package sg.edu.nus.iss.vms.common;

import java.io.Serializable;

import sg.edu.nus.iss.vms.security.dto.UserDto;

/**
 * 
 * @author zaw.htet
 */
public class SessionBean implements Serializable {

        private UserDto userDto;

        public UserDto getUser() {
                return userDto;
        }

        public void setPerson(UserDto userDto) {
                this.userDto = userDto;
        }
}
