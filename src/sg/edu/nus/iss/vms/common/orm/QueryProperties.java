
package sg.edu.nus.iss.vms.common.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import sg.edu.nus.iss.vms.common.DefaultIdValue;
import sg.edu.nus.iss.vms.common.IdValue;


/**
 * @author zaw.htet
 *
 */
public class QueryProperties implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1490045194358220507L;
	
	public static final int MATCH_STRING_DEFAULT  = 0;
	public static final int MATCH_STRING_EXACT    = 1;
	public static final int MATCH_STRING_START    = 2;
	public static final int MATCH_STRING_END      = 3;
	public static final int MATCH_STRING_ANYWHERE = 4;
	
	protected int firstResult = -1;
	protected int maxResults  = -1;
	protected int matchString = MATCH_STRING_DEFAULT;
	protected boolean ignoreCase = false;
	protected boolean matchAllExampleFields = true;

	protected List<IdValue> order = new ArrayList<IdValue>(0);

	/**
	 * @return the firstResult
	 */
	public int getFirstResult()
	{
		return firstResult;
	}

	/**
	 * @param firstResult the firstResult to set
	 */
	public QueryProperties setFirstResult(int firstResult)
	{
		this.firstResult = firstResult;
		return this;
	}

	/**
	 * @return the maxResults
	 */
	public int getMaxResults()
	{
		return maxResults;
	}

	/**
	 * @param maxResults the maxResults to set
	 */
	public QueryProperties setMaxResults(int maxResults)
	{
		this.maxResults = maxResults;
		return this;
	}
	
	/**
	 * @return the matchAllExampleFields
	 */
	public boolean isMatchAllExampleFields() {
		return matchAllExampleFields;
	}

	/**
	 * @return the matchAllExampleFields
	 */
	public boolean getMatchAllExampleFields() {
		return matchAllExampleFields;
	}

	/**
	 * @param matchAllExampleFields the matchAllExampleFields to set
	 */
	public QueryProperties setMatchAllExampleFields(boolean matchAllExampleFields) {
		this.matchAllExampleFields = matchAllExampleFields;
		return this;
	}

	/**
	 * @return the ignoreCase
	 */
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * @return the ignoreCase
	 */
	public boolean getIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * @param ignoreCase the ignoreCase to set
	 */
	public QueryProperties setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
		return this;
	}

	public QueryProperties addOrderAsc(String field)
	{
		order.add(new DefaultIdValue(field, "A"));
		return this;
	}
	
	public QueryProperties addOrderDesc(String field)
	{
		order.add(new DefaultIdValue(field, "D"));
		return this;
	}
	
	/**
	 * @return the matchString
	 */
	public int getMatchString()
	{
		return matchString;
	}

	public QueryProperties setMatchStringDefault()
	{
		this.matchString = MATCH_STRING_DEFAULT;
		return this;
	}

	public QueryProperties setMatchStringExact()
	{
		this.matchString = MATCH_STRING_EXACT;
		return this;
	}

	public QueryProperties setMatchStringStart()
	{
		this.matchString = MATCH_STRING_START;
		return this;
	}

	public QueryProperties setMatchStringEnd()
	{
		this.matchString = MATCH_STRING_END;
		return this;
	}

	public QueryProperties setMatchStringAnywhere()
	{
		this.matchString = MATCH_STRING_ANYWHERE;
		return this;
	}

	public IdValue[] getOrder()
	{
		return (IdValue[]) this.order.toArray(new DefaultIdValue[this.order.size()]);
	}
	
	public int hashCode()
	{
		return new HashCodeBuilder(59, 83)
		.append( this.firstResult )
		.append( this.maxResults )
		.append( this.matchString )
		.append( this.matchAllExampleFields )
		.append( this.order )
		.toHashCode();
	}

	public boolean equals(Object other)
	{
		if (other instanceof QueryProperties) {
			QueryProperties obj = (QueryProperties) other;

			return new EqualsBuilder()
			.append( this.firstResult, obj.firstResult )
			.append( this.maxResults, obj.maxResults )
			.append( this.matchString, obj.matchString )
			.append( this.matchAllExampleFields, obj.matchAllExampleFields )
			.append( this.getOrder(), obj.getOrder() )
			.isEquals();
		}

		return false;
	}
}
