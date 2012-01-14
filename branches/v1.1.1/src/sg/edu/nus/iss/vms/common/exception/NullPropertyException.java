package sg.edu.nus.iss.vms.common.exception;

/**
 * NullPropertyException
 *
 * <p><a href="NullPropertyException.java.html"><i>View Source</i></a></p>
 *
 * @author  zaw.htet
 * 
 */
public class NullPropertyException extends InvalidPropertyException
{
	/**
	 * Constructor.
	 *
	 * @param propertyName
	 */
	public NullPropertyException(String propertyName)
	{
		this(propertyName, propertyName + " is null");
	}
	
	/**
	 * Constructor.
	 * 
	 * @param propertyName
	 * @param msg
	 */
	public NullPropertyException(String propertyName, String msg)
	{
		super(propertyName, msg);
	}
}
