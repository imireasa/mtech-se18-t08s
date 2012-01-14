/**
 * 
 */
package sg.edu.nus.iss.vms.common;

import java.io.Serializable;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author zaw.htet
 * 
 */
public class DefaultIdValue implements IdValue, Comparable<Object>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3226352970443441080L;

	protected String id;
	protected String value;

	public DefaultIdValue(String id) {
		this.id = id;
		this.value = null;
	}

	public DefaultIdValue(String id, String value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int hashCode() {
		return new HashCodeBuilder(3, 83).append(this.id).append(this.value).toHashCode();
	}

	public boolean equals(Object other) {
		if (other instanceof IdValue) {
			IdValue obj = (IdValue) other;

			return new EqualsBuilder().append(this.getId(), obj.getId()).append(this.getValue(), obj.getValue()).isEquals();
		}

		return false;
	}

	public int compareTo(Object other) {
		if (other instanceof IdValue) {

			IdValue obj = (IdValue) other;

			return new CompareToBuilder().append(this.getId(), obj.getId()).append(this.getValue(), this.getValue()).toComparison();
		}

		throw new ClassCastException("Can't convert");
	}
}
