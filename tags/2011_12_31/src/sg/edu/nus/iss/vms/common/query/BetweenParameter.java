
package sg.edu.nus.iss.vms.common.query;

import java.io.Serializable;

/**
 * @author zaw.htet
 *
 */
public class BetweenParameter implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8417809467343707611L;
	
	protected String propertyName;
	protected Object lowValue;
	protected Object highValue;
	
	public BetweenParameter(String propertyName, Object lowValue, Object highValue)
	{
		super();
		this.propertyName = propertyName;
		this.lowValue = lowValue;
		this.highValue = highValue;
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
	 * @return the lowValue
	 */
	public Object getLowValue() {
		return lowValue;
	}
	
	/**
	 * @param lowValue the lowValue to set
	 */
	public void setLowValue(Object lowValue) {
		this.lowValue = lowValue;
	}
	
	/**
	 * @return the highValue
	 */
	public Object getHighValue() {
		return highValue;
	}
	
	/**
	 * @param highValue the highValue to set
	 */
	public void setHighValue(Object highValue) {
		this.highValue = highValue;
	}
}
