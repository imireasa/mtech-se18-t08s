package sg.edu.nus.iss.vms.common.dao;

import java.io.Serializable;
import java.util.List;

import sg.edu.nus.iss.vms.common.orm.QueryProperties;



/**
 * Data Access Object (DAO) interface.
 * This is an interface used to tag our DAO classes and to provide common methods to all DAOs.
 *
 * @author zaw.htet
 */
public interface Dao
{
    
    /**
     * Generic method to save an object - handles both update and insert.
     * @param o the object to save
     */
    public void saveObject(Object o);

    /**
     * Generic method to delete an object based on class and id
     * @param type model class to lookup
     * @param id the identifier (primary key) of the class
     */
    public void removeObject(Class type, Serializable id); 

    public void removeObjects(String Query);

    /**
     * Generic method to get an object based on class and identifier. An 
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param type model class to lookup
     * @param id the identifier (primary key) of the class
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    public Object getObject(Class type, Serializable id);
    
	/**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
	 * 
     * @param type the type of objects (a.k.a. while table) to get data from
	 * @param firstResult
	 * @param maxResults
     * @return List of populated objects
	 */
	public List getObjects(Class type, QueryProperties properties);

	/**
     * Generic method used to get all exact objects of a particular type
	 * 
     * @param type the type of objects (a.k.a. while table) to get data from
     * @param example the object for example
	 * @param properties query properties (order by, firstResults, maxResults)
     * @return List of populated objects
	 */
	public List getObjects(Class type, Object example, QueryProperties properties);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	public List getObjects(String queryString, Object[] values, QueryProperties properties);
}
