package sg.edu.nus.iss.vms.web.security;

import java.util.ArrayList;
import java.util.List;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.PermissionsAdapter;

public class MenuPermissionsAdapter implements PermissionsAdapter{

	private ArrayList<String> allowedMenus;
	
	
	
	public MenuPermissionsAdapter(List<String> allowedMenus2) {
		super();
		this.allowedMenus = (ArrayList<String>) allowedMenus2;
	}



	@Override
	public boolean isAllowed(MenuComponent menu) {
		return !allowedMenus.contains(menu.getName());
	}
	

}
