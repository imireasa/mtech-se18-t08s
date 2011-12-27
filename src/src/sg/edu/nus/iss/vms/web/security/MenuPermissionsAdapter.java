package sg.edu.nus.iss.vms.web.security;

import java.util.ArrayList;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.PermissionsAdapter;

public class MenuPermissionsAdapter implements PermissionsAdapter{

	private ArrayList<String> allowedMenus;
	
	
	
	public MenuPermissionsAdapter(ArrayList<String> allowedMenus) {
		super();
		this.allowedMenus = allowedMenus;
	}



	@Override
	public boolean isAllowed(MenuComponent menu) {
		return !allowedMenus.contains(menu.getName());
	}
	

}
