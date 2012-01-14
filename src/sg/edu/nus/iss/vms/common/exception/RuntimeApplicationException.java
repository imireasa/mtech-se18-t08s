package sg.edu.nus.iss.vms.common.exception;

import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 * Top level <code>RuntimeException</code> in the context of this application. Can be
 * used as base class for any exception occured in the <i>Data Access Layer</i>
 * and <i>Business Service Layer</i>.</p>
 * 
 * <p>For <i>Web Application Layer</i>, use
 * <code>MappedApplicationException</code> as a top-level exception because it
 * contain more user friendly message to display on the screen. </p>
 * 
 * <p><a href="RuntimeApplicationException.java.html"><i>View Source</i></a></p>
 * 
 * @see sg.edu.nus.iss.vms.common.service.exception.ApplicationException
 * 
 * @author  zaw.htet
 * 
 */
public class RuntimeApplicationException extends NestableRuntimeException
{
	/**
	 * Constructor.
	 */
	public RuntimeApplicationException()
	{
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public RuntimeApplicationException(String message)
	{
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public RuntimeApplicationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public RuntimeApplicationException(Throwable cause)
	{
		super(cause);
	}
}
