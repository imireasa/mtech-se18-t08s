package sg.edu.nus.iss.vms.common.orm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import sg.edu.nus.iss.vms.common.dao.Dao;

/**
 * Base interface for Business Services to access data (CRUD - Create/Save,
 * Retrieve/Get/List, Update/Save, Delete/Remove)
 * 
 * @author zaw.htet
 * @version $Revision$
 */
public interface Manager {
	/**
	 * Expose the setDao method for testing purposes
	 * 
	 * @param dao
	 */
	public void setDao(Dao dao);

	/**
	 * Generic method to get all objects of a particular type.
	 * 
	 * @param type
	 *            entity type (JavaBean/POJO)
	 * @return List of populated objects
	 */
	public List list(Class type);

	/**
	 * Generic method to get all objects of a particular type, with customize
	 * limit result
	 * 
	 * @param type
	 *            entity type (JavaBean/POJO)
	 * @param properties
	 *            query properties
	 * @return List of populated objects
	 */
	public List list(Class type, QueryProperties properties);

	/**
	 * Generic method used to get all objects based on example ('AND' criteria).
	 * 
	 * @param example
	 *            the identifier of the class, valid value are Serializable Map
	 *            and Serializable JavaBean (Default)
	 * @return List of populated objects
	 */
	public List list(Class type, Object example);

	/**
	 * Generic method used to get all objects based on example ('AND' criteria)
	 * with customize limit result.
	 * 
	 * @param type
	 *            entity type (JavaBean/POJO)
	 * @param example
	 *            the identifier of the class, valid value are Serializable Map
	 *            and Serializable JavaBean (Default)
	 * @param properties
	 *            query properties
	 * @return List of populated objects
	 */
	public List list(Class type, Object example, QueryProperties properties);

	/**
	 * Generic method used to get any objects based on criteria ('OR' criteria).
	 * 
	 * @param example
	 *            the identifier of the class, valid value are Serializable Map
	 *            and Serializable JavaBean (Default)
	 * @return List of populated objects
	 */
	public List find(Class type, Object example);

	/**
	 * Generic method used to get any objects based on example ('OR' criteria)
	 * with customize limit result.
	 * 
	 * @param type
	 *            entity type (JavaBean/POJO)
	 * @param example
	 *            the identifier of the class, valid value are Serializable Map
	 *            and Serializable JavaBean (Default)
	 * @param properties
	 *            query properties
	 * @return List of populated objects
	 */
	public List find(Class type, Object example, QueryProperties properties);

	/**
	 * 
	 * @param queryString
	 * @return
	 */
	public List find(String queryString);

	/**
	 * 
	 * @param queryString
	 * @param value
	 * @return
	 */
	public List find(String queryString, Object value);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	public List find(String queryString, Object[] values);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @param properties
	 *            query properties
	 * @return
	 */
	public List find(String queryString, Object[] values,
			QueryProperties properties);

	/**
	 * 
	 * @param namedQuery
	 *            - the key to the named query
	 * @param values
	 * @param properties
	 *            query properties
	 * @return
	 */
	public List findByNamedQuery(String namedQuery, HashMap values,
			QueryProperties properties);

	/**
	 * Generic method to get an object based on class and identifier.
	 * 
	 * @param id
	 *            the identifier (primary key) of the class
	 * 
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	public Object get(Class type, Serializable id);

	/**
	 * Generic method to save an object.
	 * 
	 * @param obj
	 *            the object to save
	 */
	public void save(Object obj);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param id
	 *            the identifier of the class
	 */
	public void remove(Class type, Serializable id);

	public void removeObjects(String query);

	List findByDetachedCriteria(DetachedCriteria criteria);
}
