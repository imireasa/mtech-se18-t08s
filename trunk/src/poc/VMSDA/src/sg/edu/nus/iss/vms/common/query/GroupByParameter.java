
package sg.edu.nus.iss.vms.common.query;

import java.io.Serializable;

/**
 * @author zaw.htet
 *
 */
public class GroupByParameter implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8808658716630407017L;
	
	protected String propertyName;
	protected String propertyParameter;
	protected String orderBy;
	
	
	public GroupByParameter(String propertyName, String propertyParameter) {
		super();
		this.propertyName = propertyName;
		this.propertyParameter= propertyParameter;
	}
	
	public GroupByParameter(String propertyName,String propertyParameter,String orderBy) {
		super();
		this.propertyName = propertyName;
		this.propertyParameter=propertyParameter;
		this.orderBy=orderBy;
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

	public String getPropertyParameter() {
		return propertyParameter;
	}

	public void setPropertyParameter(String propertyParameter) {
		this.propertyParameter = propertyParameter;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
