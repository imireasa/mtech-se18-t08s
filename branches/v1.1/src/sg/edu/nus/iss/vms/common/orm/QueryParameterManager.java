
package sg.edu.nus.iss.vms.common.orm;

import java.util.List;

import sg.edu.nus.iss.vms.common.dao.QueryParameterDao;


/**
 * @author zaw.htet
 *
 */
public interface QueryParameterManager
{
	void setQueryParameterDao(QueryParameterDao dao);

	/**
	 * Find based on QueryParameter
	 *
	 * @param parameter
	 * @return
	 */
	List find(QueryParameter parameter);
	
	/**
	 * Find based on QueryParameter
	 *
	 * @param parameter
	 * @param properties
	 * @return
	 */
	List find(QueryParameter parameter, QueryProperties properties);
}
