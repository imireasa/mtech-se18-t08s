
package sg.edu.nus.iss.vms.common.orm.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;

/**
 * Modified version of org.hibernate.criterion.Example
 * @author zaw.htet
 *
 */
public class AnyExample extends Example
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7781534229908887750L;

//	private final Object entity;
//	private final Set excludedProperties = new HashSet();
//	private PropertySelector selector;
	private boolean isLikeEnabled;
	private Character escapeCharacter;
	private boolean isIgnoreCaseEnabled;
	private MatchMode matchMode;

	private static final PropertySelector NOT_NULL = new NotNullPropertySelector();
	private static final PropertySelector ALL = new AllPropertySelector();
	private static final PropertySelector NOT_NULL_OR_ZERO = new NotNullOrZeroPropertySelector();

	static final class AllPropertySelector implements PropertySelector
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 7844632846302463178L;

		public boolean include(Object object, String propertyName, Type type) {
			return true;
		}

		private Object readResolve() {
			return ALL;
		}
	}

	static final class NotNullPropertySelector implements PropertySelector
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 2884881599605309894L;

		public boolean include(Object object, String propertyName, Type type) {
			return object!=null;
		}

		private Object readResolve() {
			return NOT_NULL;
		}
	}

	static final class NotNullOrZeroPropertySelector implements PropertySelector
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 5288299347718659916L;

		public boolean include(Object object, String propertyName, Type type) {
			return object!=null && (
					!(object instanceof Number) || ( (Number) object ).longValue()!=0
			);
		}

		private Object readResolve() {
			return NOT_NULL_OR_ZERO;
		}
	}

	/**
	 * Set escape character for "like" clause
	 */
	public Example setEscapeCharacter(Character escapeCharacter)
	{
		super.setEscapeCharacter(escapeCharacter);

		this.escapeCharacter = escapeCharacter;
		return this;
	}

	/**
	 * Exclude zero-valued properties
	 */
	public Example excludeZeroes()
	{
		super.excludeZeroes();

		setPropertySelector(NOT_NULL_OR_ZERO);
		return this;
	}

	/**
	 * Don't exclude null or zero-valued properties
	 */
	public Example excludeNone()
	{
		super.excludeNone();

		setPropertySelector(ALL);
		return this;
	}

	/**
	 * Use the "like" operator for all string-valued properties
	 */
	public Example enableLike(MatchMode matchMode)
	{
		super.enableLike(matchMode);

		isLikeEnabled = true;
		this.matchMode = matchMode;
		return this;
	}

	/**
	 * Use the "like" operator for all string-valued properties
	 */
	public Example enableLike()
	{
		super.enableLike();

		return enableLike(MatchMode.EXACT);
	}

	/**
	 * Ignore case for all string-valued properties
	 */
	public Example ignoreCase()
	{
		super.ignoreCase();

		isIgnoreCaseEnabled = true;
		return this;
	}


	protected AnyExample(Object entity, PropertySelector selector)
	{
		super(entity, selector);
//		this.entity = entity;
//		this.selector = selector;
	}
	/**
	 * Create a new instance, which includes all non-null properties
	 * by default
	 * @param entity
	 * @return a new instance of <tt>AnyExample</tt>
	 */
	public static AnyExample create(Object entity)
	{
		if (entity==null) throw new NullPointerException("null AnyExample");
		return new AnyExample(entity, NOT_NULL);
	}

	protected void appendPropertyCondition(
			String propertyName,
			Object propertyValue,
			Criteria criteria,
			CriteriaQuery cq,
			StringBuffer buf)
	throws HibernateException
	{
		Criterion crit = null;
		if ( propertyValue!=null ) {
			boolean isString = propertyValue instanceof String;
			if ( isLikeEnabled && isString ) {
				crit = new sg.edu.nus.iss.vms.common.orm.hibernate.criterion.LikeExpression(
						propertyName,
						( String ) propertyValue,
						matchMode,
						escapeCharacter,
						isIgnoreCaseEnabled
				);
			}
			else {
				crit = new sg.edu.nus.iss.vms.common.orm.hibernate.criterion.SimpleExpression( propertyName, propertyValue, "=", isIgnoreCaseEnabled && isString );
			}
		}
		else {
			crit = new sg.edu.nus.iss.vms.common.orm.hibernate.criterion.NullExpression(propertyName);
		}
		String critCondition = crit.toSqlString(criteria, cq);
		if ( buf.length()>1 && critCondition.trim().length()>0 ) buf.append(" or ");
		buf.append(critCondition);
	}
}
