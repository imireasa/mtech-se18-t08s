package sg.edu.nus.iss.vms.common.web.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.vo.UserSessionInfoVo;

/**
 * Utility class use to get request information from context.
 */
public class UserUtil {
    
    private static Logger logger = Logger.getLogger(UserUtil.class);
    
    /**
     * Utility class should not have a public constructor.
     */
    private UserUtil(){}

    /**
     * Get User Session Info from the session map of FaceContext Object.
     * 
     * @return user session info object.
     */
    public static UserSessionInfoVo getUserSessionInfoVo () {
        UserSessionInfoVo sessionInfo = null;
        
        HttpServletRequest curRequest = 
        	((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
        	.getRequest();
        sessionInfo = (UserSessionInfoVo) curRequest.getSession().getAttribute((Messages.getString("AuthorisationFilter.SESSION_USER_ALLOWED_MENU_ATTR_NME")));
        return sessionInfo;
    }
}
