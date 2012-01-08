package sg.edu.nus.iss.vms.common.exception;

/**
 * MappedApplicationException
 *
 * <p><a href="MappedApplicationException.java.html"><i>View Source</i></a></p>
 *
 * @author  zaw.htet
 *
 */
public class MappedApplicationException extends ApplicationException
{
	private String code;
	private String module;
	private String friendlyMessage;
	
	/**
	 * Constructor.
	 */
	public MappedApplicationException()
	{
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param code
	 * @param module
	 */
	public MappedApplicationException(String code, String module)
	{
		super();
		setCode(code);
		setModule(module);
	}

	/**
	 * Constructor.
	 *
	 * @param code
	 * @param module
	 * @param cause
	 */
	public MappedApplicationException(String code, String module, Throwable cause)
	{
		super(cause);
		setCode(code);
		setModule(module);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public MappedApplicationException(Throwable cause)
	{
		super(cause);
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getModule()
	{
		return module;
	}

	public void setModule(String module)
	{
		this.module = module;
	}

	public String getFriendlyMessage()
	{
		return friendlyMessage;
	}

	public void setFriendlyMessage(String friendlyMessage)
	{
		this.friendlyMessage = friendlyMessage;
	}
}
