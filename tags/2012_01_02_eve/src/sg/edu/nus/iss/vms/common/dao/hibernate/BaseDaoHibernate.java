package sg.edu.nus.iss.vms.common.dao.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import sg.edu.nus.iss.vms.common.IdValue;
import sg.edu.nus.iss.vms.common.dao.Dao;
import sg.edu.nus.iss.vms.common.orm.QueryProperties;
import sg.edu.nus.iss.vms.common.orm.hibernate.criterion.AnyExample;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common methods that they might all use. Can be used for standard CRUD
 * operations. Based on <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * appFuse
 * 
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * 
 */
@SuppressWarnings("unchecked")
public class BaseDaoHibernate extends HibernateDaoSupport implements Dao {

	/**
	 * Logger
	 */
	protected Logger log = Logger.getLogger(BaseDaoHibernate.class);

	/**
	 * @see csg.edu.nus.iss.vms.dao.Dao#saveObject(java.lang.Object)
	 */
	@Override
	public void saveObject(Object o) {

		try {
			getHibernateTemplate().saveOrUpdate(o);
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * @see sg.edu.nus.iss.vms.common.dao.Dao#removeObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	@Override
	public void removeObject(Class type, Serializable id) {

		try {
			getHibernateTemplate().delete(getObject(type, id));
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * @see sg.edu.nus.iss.vms.common.dao.Dao#removeObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	@Override
	public void removeObjects(String query) {
		try {
			getHibernateTemplate().bulkUpdate(query);
		} catch (Exception e) {
			log.error(e);
		}

	}

	/**
	 * @see sg.edu.nus.iss.vms.common.dao.Dao#getObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	@Override
	public Object getObject(Class type, Serializable id) {

		Object o = getHibernateTemplate().get(type, id);

		if (o == null) {
			throw new ObjectRetrievalFailureException(type, id);
		}

		return o;
	}

	@Override
	public List getObjects(Class type, QueryProperties properties) {
		if (properties != null) {
			DetachedCriteria criteria = DetachedCriteria.forClass(type);
			criteria = addOrder(criteria, properties.getOrder());
			return getHibernateTemplate().findByCriteria(criteria,
					properties.getFirstResult(), properties.getMaxResults());
		} else {
			return getHibernateTemplate().loadAll(type);
		}
	}

	@Override
	public List getObjects(final Class type, final Object example,
			final QueryProperties properties) {
		if (properties != null) {
			//
			// Example is a Map
			//
			if (example != null && example instanceof Map) {
				return (List) getHibernateTemplate().executeWithNativeSession(
						new ListHibernateCallback(type, (Map) example,
								properties));
			}

			//
			// Example is a JavaBean
			//

			// Search by All (AND) or Search by Any (OR)
			Example ex = properties.isMatchAllExampleFields() ? Example
					.create(example) : AnyExample.create(example);

			if (properties.getMatchString() == QueryProperties.MATCH_STRING_ANYWHERE) {
				ex.enableLike(MatchMode.ANYWHERE);
			} else if (properties.getMatchString() == QueryProperties.MATCH_STRING_START) {
				ex.enableLike(MatchMode.START);
			} else if (properties.getMatchString() == QueryProperties.MATCH_STRING_END) {
				ex.enableLike(MatchMode.END);
			} else if (properties.getMatchString() == QueryProperties.MATCH_STRING_EXACT) {
				ex.enableLike(MatchMode.EXACT);
			}

			if (properties.isIgnoreCase()) {
				ex.ignoreCase();
			}

			DetachedCriteria criteria = DetachedCriteria.forClass(
					example.getClass()).add(ex);

			criteria = addOrder(criteria, properties.getOrder());

			return getHibernateTemplate().findByCriteria(criteria,
					properties.getFirstResult(), properties.getMaxResults());
		} else {
			//
			// Example is a Map
			//
			if (example != null && example instanceof Map) {
				return (List) getHibernateTemplate().executeWithNativeSession(
						new ListHibernateCallback(type, (Map) example));
			}

			//
			// Example is a JavaBean
			//
			return getHibernateTemplate().findByExample(example);
		}
	}

	@Override
	public List getObjects(final String queryString, final Object[] values,
			final QueryProperties properties) {
		return (List) getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query queryObject = session.createQuery(queryString);

						// TODO implement this
						// isCacheQueries available
						// if (isCacheQueries()) {
						// queryObject.setCacheable(true);
						// if (getQueryCacheRegion() != null) {
						// queryObject.setCacheRegion(getQueryCacheRegion());
						// }
						// }
						SessionFactoryUtils.applyTransactionTimeout(
								queryObject, getSessionFactory());

						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								queryObject.setParameter(i, values[i]);
							}
						}

						if (properties != null) {
							if (properties.getFirstResult() >= 0) {
								queryObject.setFirstResult(properties
										.getFirstResult());
							}
							if (properties.getMaxResults() > 0) {
								queryObject.setMaxResults(properties
										.getMaxResults());
							}
						}

						return queryObject.list();
					}
				});
	}

	@Override
	public List getObjectsByNamedQuery(String namedQueryReference,
			HashMap values, QueryProperties properties) {
		Query query = getSession().getNamedQuery(namedQueryReference);
		log.debug("getObjectsByNamedQuery - values passed in " + values);
		Iterator it = values.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			log.debug("getObjectsByNamedQuery - putting key "
					+ (String) pairs.getKey() + " into value "
					+ pairs.getValue());
			query.setParameter((String) pairs.getKey(), pairs.getValue());
		}

		return query.list();

	}

	//
	// Internal method
	//
	protected DetachedCriteria addOrder(DetachedCriteria criteria,
			IdValue[] order) {
		if (criteria != null) {
			int length = order != null ? order.length : 0;
			for (int i = 0; i < length; i++) {
				if ("D".equalsIgnoreCase(order[i].getValue())) {
					criteria.addOrder(Order.desc(order[i].getId()));
				} else {
					criteria.addOrder(Order.asc(order[i].getId()));
				}
			}
		}
		return criteria;
	}

	// ----- INTERNAL CLASS -----
	class ListHibernateCallback implements HibernateCallback {

		private final Class type;
		private final Map map;
		private final QueryProperties properties;

		protected ListHibernateCallback(Class type, Map map) {
			this(type, map, new QueryProperties());
		}

		protected ListHibernateCallback(Class type, Map map,
				QueryProperties properties) {
			this.type = type;
			this.map = map;
			this.properties = properties;
		}

		@Override
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			StringBuffer sb = new StringBuffer().append("from ")
					.append(this.type.getName()).append(" x");
			if (this.map.size() > 0) {
				int i = 0;
				for (Iterator iter = map.keySet().iterator(); iter.hasNext(); i++) {
					String key = iter.next().toString();

					if (i == 0) {
						sb.append(" where ");
					} else {
						if (properties.getMatchAllExampleFields()) {
							sb.append(" and ");
						} else {
							sb.append(" or ");
						}
					}

					Object obj = map.get(key);
					if (obj instanceof String) {
						sb.append("x.").append(key).append(" LIKE '")
								.append(obj).append("'");
					} else {
						sb.append("x.").append(key).append("=").append(obj);
					}

					// add order if any
					if (this.properties != null) {
						IdValue[] order = this.properties.getOrder();
						int length = order != null ? order.length : 0;
						for (int j = 0; j < length; j++) {
							if (j > 0) {
								sb.append(", ");
							} else {
								sb.append(" ORDER BY ");
							}

							if ("D".equalsIgnoreCase(order[j].getValue())) {
								sb.append("x.");
								sb.append(order[j].getId());
								sb.append(" DESC");
							} else {
								sb.append("x.");
								sb.append(order[j].getId());
								sb.append(" ASC");
							}
						}
					}
				}
			}
			Query query = session.createQuery(sb.toString());

			if (this.properties != null) {
				if (this.properties.getFirstResult() >= 0) {
					query.setFirstResult(this.properties.getFirstResult());
				}
				if (this.properties.getMaxResults() > 0) {
					query.setMaxResults(this.properties.getMaxResults());
				}
			}
			return query.list();
		}
	}

	public List getObjectbyCriterion(DetachedCriteria criteria) {
		if (criteria != null) {

			return getHibernateTemplate().findByCriteria(criteria);
		}
		return null;
	}
}
