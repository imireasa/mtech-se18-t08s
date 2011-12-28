package sg.edu.nus.iss.vms.web.security;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.PermissionsAdapter;

public class MenuPermissionsAdapter implements PermissionsAdapter{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MenuPermissionsAdapter.class);

	private ArrayList<String> allowedMenus;
	
	
	
	public MenuPermissionsAdapter(List<String> allowedMenus2) {
		super();
		this.allowedMenus = (ArrayList<String>) allowedMenus2;
	}



	@Override
	public boolean isAllowed(MenuComponent menu) {
		if (logger.isDebugEnabled()) {
			logger.debug("isAllowed(MenuComponent) - start"); //$NON-NLS-1$
		}
		

		boolean returnboolean = !allowedMenus.contains(menu.getName());
		logger.debug("checking for "+menu.getName()+ "result is "+returnboolean);
		if (logger.isDebugEnabled()) {
			logger.debug("isAllowed(MenuComponent) - end"); //$NON-NLS-1$
		}
		return returnboolean;
	}
	

}
