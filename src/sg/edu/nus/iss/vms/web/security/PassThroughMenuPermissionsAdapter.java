package sg.edu.nus.iss.vms.web.security;


import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.PermissionsAdapter;

public class PassThroughMenuPermissionsAdapter implements PermissionsAdapter {

	@Override
	public boolean isAllowed(MenuComponent menu) {
		return true;
	}

}
