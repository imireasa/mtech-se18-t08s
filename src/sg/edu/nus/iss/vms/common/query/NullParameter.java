
package sg.edu.nus.iss.vms.common.query;

import java.io.Serializable;

/**
 * @author zaw.htet
 *
 */
public class NullParameter implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8808658716630407017L;
	
	protected String propertyName;
	protected boolean propertyNull;
	
	
	public NullParameter(String propertyName, boolean propertyNull) {
		super();
		this.propertyName = propertyName;
		this.propertyNull = propertyNull;
	}
	
	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	/**
	 * @return the propertyNull
	 */
	public boolean isPropertyNull() {
		return propertyNull;
	}
	
	/**
	 * @param propertyNull the propertyNull to set
	 */
	public void setPropertyNull(boolean propertyNull) {
		this.propertyNull = propertyNull;
	}
}
