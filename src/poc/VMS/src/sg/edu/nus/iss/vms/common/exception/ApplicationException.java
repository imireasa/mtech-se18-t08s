package sg.edu.nus.iss.vms.common.exception;

import org.apache.commons.lang.exception.NestableException;

/**
 * Top level <code>Exception</code> in the context of this application. Can be
 * used as base class for any exception occured in the <i>Data Access Layer</i>
 * and <i>Business Service Layer</i>.</p>
 * 
 * <p>For <i>Web Application Layer</i>, use
 * <code>MappedApplicationException</code> as a top-level exception because it
 * contain more user friendly message to display on the screen. </p>
 * 
 * <p><a href="ApplicationException.java.html"><i>View Source</i></a></p>
 * 
 * @see com.ec2.bill.MappedApplicationException
 * @see com.ec2.bill.RuntimeApplicationException
 * 
 * @author  zaw.htet
 * 
 */
public class ApplicationException extends NestableException
{
	/**
	 * Constructor.
	 */
	public ApplicationException()
	{
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 */
	public ApplicationException(String message)
	{
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 */
	public ApplicationException(Throwable cause)
	{
		super(cause);
	}
}
