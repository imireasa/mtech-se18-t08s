
package sg.edu.nus.iss.vms.common.query;

import java.io.Serializable;

/**
 * @author zaw.htet
 *
 */
public class LikeParameter implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String propertyName;
	protected Object value;
	
	protected boolean ignoreCase = true;
	protected boolean distinctPropertyName = false;
	
	protected boolean propertyNotLike;
	
	public LikeParameter(String propertyName, Object value, boolean ignoreCase, boolean toDistinct, boolean propertyNotLike)
	{
		super();
		this.propertyName = propertyName;
		this.value = value;
		this.ignoreCase = ignoreCase;
		this.distinctPropertyName = toDistinct;
		this.propertyNotLike = propertyNotLike;
	}

	/*
	public LikeParameter(String propertyName, Object value, boolean propertyNotLike)
	{
		super();
		this.propertyName = propertyName;
		this.value = value;
		this.propertyNotLike = propertyNotLike;
	}
	*/

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

	public boolean isPropertyNotLike() {
		return propertyNotLike;
	}

	public void setPropertyNotLike(boolean propertyNotLike) {
		this.propertyNotLike = propertyNotLike;
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
}
