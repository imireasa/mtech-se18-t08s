
package sg.edu.nus.iss.vms.common.orm.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.engine.TypedValue;
import org.hibernate.util.StringHelper;

/**
 * NOTE: This class is identical with original hibernate.
 * This class exist to make class 'AnyExample' work!.
 * 
 * Constrains a property to be null
 * @author Gavin King
 */
public class NullExpression implements org.hibernate.criterion.Criterion
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6381887513975999851L;

	private final String propertyName;

	private static final TypedValue[] NO_VALUES = new TypedValue[0];

	protected NullExpression(String propertyName)
	{
		this.propertyName = propertyName;
	}

	public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) 
	throws HibernateException
	{
		String[] columns = criteriaQuery.getColumnsUsingProjection(criteria, propertyName);
		String result = StringHelper.join(
			" and ",
			StringHelper.suffix( columns, " is null" )
		);
		if (columns.length>1) result = '(' + result + ')';
		return result;

		//TODO: get SQL rendering out of this package!
	}

	public TypedValue[] getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) 
	throws HibernateException
	{
		return NO_VALUES;
	}

	public String toString()
	{
		return propertyName + " is null";
	}

}