
package sg.edu.nus.iss.vms.common.query;

import java.io.Serializable;

/**
 * @author zaw.htet
 *
 */
public class InParameter implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9136223384176639979L;
	
	protected String propertyName;
	protected Object[] values;
	
	public InParameter(String propertyName, Object[] values)
	{
		super();
		this.propertyName = propertyName;
		this.values = values;
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
	 * @return the values
	 */
	public Object[] getValues() {
		return values;
	}
	
	/**
	 * @param values the values to set
	 */
	public void setValues(Object[] values) {
		this.values = values;
	}

}
