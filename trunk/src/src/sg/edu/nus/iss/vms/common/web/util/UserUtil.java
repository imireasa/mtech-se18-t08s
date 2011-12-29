package sg.edu.nus.iss.vms.common.web.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
        /*if(context == null){
            return (UserSessionInfoVo) RequestContextHolder.getCaseConnectContext().getAttribute(Constants.USER_SESSION_INFO);
        }
        ExternalContext content = context.getExternalContext();
        sessionInfo = (UserSessionInfoVo)content.getSessionMap().get(Constants.USER_SESSION_INFO);*/
//        if(logger.isDebugEnabled()){
//            logger.debug("######@@@@@@@@@Session Info@@@@@@@@@@@>>>>>>>>>>User Id:"+sessionInfo.getUserID());
//            logger.debug("######@@@@@@@@@Session Info@@@@@@@@@@@>>>>>>>>>>User Name:"+sessionInfo.getName());
//            logger.debug("######@@@@@@@@@Session Info@@@@@@@@@@@>>>>>>>>>>User Roles:"+sessionInfo.getRoles());
//        }
        
        //ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        return sessionInfo;
    }
}
