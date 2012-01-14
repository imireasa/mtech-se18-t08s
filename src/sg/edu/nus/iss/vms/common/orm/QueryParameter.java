
package sg.edu.nus.iss.vms.common.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.vms.common.query.BetweenParameter;
import sg.edu.nus.iss.vms.common.query.GroupByParameter;
import sg.edu.nus.iss.vms.common.query.InParameter;
import sg.edu.nus.iss.vms.common.query.LikeParameter;
import sg.edu.nus.iss.vms.common.query.NullParameter;
import sg.edu.nus.iss.vms.common.query.OperatorParameter;


/**
 * @author zaw.htet
 *
 */
@SuppressWarnings("unchecked")
public class QueryParameter implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1736954712328602263L;
	
	protected List parameters;
	protected Class type = null;
	
	public QueryParameter(Class type)
	{
		this.type = type;
		this.parameters = new ArrayList();
	}
	
	public QueryParameter addOperatorParameter(String propertyName, String operator, Object value)
	{
		this.parameters.add(new OperatorParameter(propertyName, operator, value, true, false));
		return this;
	}
	
	public QueryParameter addOperatorParameter(String propertyName, String operator, Object value, boolean ignoreCase, boolean distinctPropertyName)
	{
		this.parameters.add(new OperatorParameter(propertyName, operator, value, ignoreCase, distinctPropertyName));
		return this;
	}
	
	public QueryParameter addBetweenParameter(String propertyName, Object lowValue, Object highValue)
	{
		this.parameters.add(new BetweenParameter(propertyName, lowValue, highValue));
		return this;
	}
	
	public QueryParameter addInParameter(String propertyName, Object[] parameters)
	{
		this.parameters.add(new InParameter(propertyName, parameters));
		return this;
	}
	
	public QueryParameter addNullParameter(String propertyName)
	{
		this.parameters.add(new NullParameter(propertyName, true));
		return this;
	}
	
	public QueryParameter addNotNullParameter(String propertyName)
	{
		this.parameters.add(new NullParameter(propertyName, false));
		return this;
	}
	
	public QueryParameter addLikeParameter(String propertyName, Object value)
	{
		this.parameters.add(new LikeParameter(propertyName, value, true, false, true));
		return this;
	}
	
	public QueryParameter addLikeParameter(String propertyName, Object value, boolean ignoreCase, boolean distinctPropertyName)
	{
		this.parameters.add(new LikeParameter(propertyName, value, ignoreCase, distinctPropertyName, true));
		return this;
	}
	
	public QueryParameter addNotLikeParameter(String propertyName, Object value)
	{
		this.parameters.add(new LikeParameter(propertyName, value, true, false, false));
		return this;
	}
	
	public QueryParameter addNotLikeParameter(String propertyName, Object value, boolean ignoreCase, boolean distinctPropertyName)
	{
		this.parameters.add(new LikeParameter(propertyName, value, ignoreCase, distinctPropertyName, false));
		return this;
	}
	
	public QueryParameter addGroupByParameter(String propertyName)
	{
		this.parameters.add(new GroupByParameter(propertyName,"group"));
		return this;
	}
	
	public QueryParameter addOrderByParameter(String propertyName, String orderBy)
	{
		this.parameters.add(new GroupByParameter(propertyName,"order",orderBy));
		return this;
	}
	
	/**
	 * @return the type
	 */
	public Class getType() {
		return type;
	}

	public Object getParameter(int index)
	{
		return this.parameters.get(index);
	}
	
	public List getParameters()
	{
		return this.parameters;
	}
}
