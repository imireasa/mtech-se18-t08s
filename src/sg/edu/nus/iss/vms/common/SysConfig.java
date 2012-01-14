package sg.edu.nus.iss.vms.common;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class SysConfig {
	private static final String BUNDLE_NAME = "sysconfig"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private SysConfig() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		}
		catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getString(String key, String[] values) {
		try {
			String keyMessaage = RESOURCE_BUNDLE.getString(key);
			MessageFormat form = new MessageFormat(keyMessaage);
			return form.format(values);
			
		}
		catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
