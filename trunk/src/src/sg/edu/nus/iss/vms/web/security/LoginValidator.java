package sg.edu.nus.iss.vms.web.security;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.edu.nus.iss.vms.common.Messages;


public class LoginValidator implements Validator {

   @Override
    public boolean supports(Class clazz) {
        return LoginCommand.class.isAssignableFrom(clazz);
    }
    public void validate(Object obj, Errors errors) {
        LoginCommand login = (LoginCommand) obj;        
        if (login.getUsername() == null || login.getUsername().length() == 0) {
            errors.rejectValue("username", "error.empty.field", Messages.getString("message.common.error.mandatory", new String[]{"User ID"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        if (login.getPassword() == null || login.getPassword().length() == 0) {
            errors.rejectValue("password", "error.empty.field", Messages.getString("message.common.error.mandatory", new String[]{"Password"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        
    }
}



 
