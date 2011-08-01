package sg.edu.nus.iss.vms.common.service.impl;

import java.util.List;

import sg.edu.nus.iss.vms.common.dao.QueryParameterDao;
import sg.edu.nus.iss.vms.common.orm.QueryParameter;
import sg.edu.nus.iss.vms.common.orm.QueryParameterManager;
import sg.edu.nus.iss.vms.common.orm.QueryProperties;



/**
 * @author zaw.htet
 *
 */
public class BaseQueryParameterManager extends BaseManager implements QueryParameterManager
{
	protected QueryParameterDao qpDao;

	public void setQueryParameterDao(QueryParameterDao dao)
	{
		this.qpDao = dao;
	}

	/* (non-Javadoc)
	 * @see sg.edu.nus.iss.vms.common.orm.service.QueryParameterManager#find(sg.edu.nus.iss.vms.common.orm.service.QueryParameter)
	 */
	public List find(QueryParameter parameter) {
		return this.qpDao.getObjects(parameter, (QueryProperties) null);
	}

	/* (non-Javadoc)
	 * @see sg.edu.nus.iss.vms.common.orm.service.QueryParameterManager#find(sg.edu.nus.iss.vms.common.orm.service.QueryParameter,sg.edu.nus.iss.vms.common.orm.service.QueryProperties)
	 */
	public List find(QueryParameter parameter, QueryProperties properties) {
		return this.qpDao.getObjects(parameter, properties);
	}
}
