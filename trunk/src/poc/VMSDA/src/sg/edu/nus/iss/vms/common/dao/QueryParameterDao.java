
package sg.edu.nus.iss.vms.common.dao;

import java.util.List;

import sg.edu.nus.iss.vms.common.orm.QueryParameter;
import sg.edu.nus.iss.vms.common.orm.QueryProperties;


/**
 * @author zaw.htet
 *
 */
public interface QueryParameterDao
{
	List getObjects(QueryParameter parameter, QueryProperties properties);
}
