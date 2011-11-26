
package sg.edu.nus.iss.vms.common.exception;

/**
 * InvalidPropertyException
 *
 * <p><a href="InvalidPropertyException.java.html"><i>View Source</i></a></p>
 *
 * @author zaw.htet
 * @version $Revision$
 */
public class InvalidPropertyException extends ApplicationException
{
	/**
	 * Property Name
	 */
	private String propertyName;
	
	/**
	 * Constructor.
	 *
	 * @param propertyName
	 */
	public InvalidPropertyException(String propertyName)
	{
		super("Oops..! Property " + propertyName
				+ " is not properly specified. "
				+ "Please check your configuration, okay?");
		this.propertyName = propertyName;
	}
	
	/**
	 * Constructor.
	 * 
	 * @param propertyName
	 * @param msg
	 */
	public InvalidPropertyException(String propertyName, String msg)
	{
		super("Oops..! Property " + propertyName
				+ " is not properly specified. "
				+ "Please check your configuration : " + msg);
		this.propertyName = propertyName;
	}

	/**
	 * Gets the corresponding propertyName
	 * 
	 * @return the property name
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
}
