
package sg.edu.nus.iss.vms.common.query;

import java.io.Serializable;

/**
 * @author zaw.htet
 *
 */
public class OperatorParameter implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6273730194436687186L;

	protected String propertyName;
	protected String operator;
	protected Object value;
	
	protected boolean ignoreCase = true;
	protected boolean distinctPropertyName = false;
	
/*	
	public OperatorParameter(String propertyName, String operator, Object value)
	{
		super();
		this.propertyName = propertyName;
		this.setOperator(operator);
		this.value = value;
	}
*/
	public OperatorParameter(String propertyName, String operator, Object value, boolean ignoreCase, boolean toDistinct)
	{
		super();
		this.propertyName = propertyName;
		this.setOperator(operator);
		this.value = value;
		this.ignoreCase = ignoreCase;
		this.distinctPropertyName = toDistinct;
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
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
		if (!isLegalOperator()) {
			throw new IllegalArgumentException("Invalid operator!");
		}
	}
	
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	
	/**
	 * @return the ignoreCase
	 */
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * @param ignoreCase the ignoreCase to set
	 */
	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	/**
	 * @return the distinctPropertyName
	 */
	public boolean isDistinctPropertyName() {
		return distinctPropertyName;
	}

	/**
	 * @param distinctPropertyName the distinctPropertyName to set
	 */
	public void setDistinctPropertyName(boolean distinctPropertyName) {
		this.distinctPropertyName = distinctPropertyName;
	}

	private boolean isLegalOperator() {
		if (operator == null)
			return false;
		
		operator = operator.trim().toLowerCase();
		
		if ("like".equals(operator)) {
			operator = " like ";
			return true;
		}
		if ("=".equals(operator))
			return true;
		if ("<>".equals(operator))
			return true;
		if (">".equals(operator))
			return true;
		if (">=".equals(operator))
			return true;
		if ("<".equals(operator))
			return true;
		if ("<=".equals(operator))
			return true;

		return false;
	}

}
