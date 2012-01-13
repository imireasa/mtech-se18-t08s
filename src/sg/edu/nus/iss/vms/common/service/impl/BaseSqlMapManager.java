package sg.edu.nus.iss.vms.common.service.impl;


import java.util.List;

import sg.edu.nus.iss.vms.common.dao.ibatis.SqlMapDao;
import sg.edu.nus.iss.vms.common.orm.SqlMapManager;


/**
 * @author zaw.htet
 *
 */
@SuppressWarnings("unchecked")
public class BaseSqlMapManager implements SqlMapManager
{
	protected SqlMapDao sqlMapDao;
	
	public void setSqlMapDao(SqlMapDao dao)
	{
		this.sqlMapDao = dao;
	}

	/* (non-Javadoc)
	 * @see com.masvent.cms.service.SqlMapManager#find(java.lang.String)
	 */
	public List find(String statementName)
	{
		return sqlMapDao.getObjects(statementName);
	}

	/* (non-Javadoc)
	 * @see com.masvent.cms.service.SqlMapManager#find(java.lang.String, java.lang.Object)
	 */
	public List find(String statementName, Object parameterObject)
	{
		return sqlMapDao.getObjects(statementName, parameterObject);
	}

	/* (non-Javadoc)
	 * @see com.masvent.cms.service.SqlMapManager#get(java.lang.String)
	 */
	public Object get(String statementName)
	{
		return sqlMapDao.getObject(statementName);
	}

	/* (non-Javadoc)
	 * @see com.masvent.cms.service.SqlMapManager#get(java.lang.String, java.lang.Object)
	 */
	public Object get(String statementName, Object parameterObject)
	{
		return sqlMapDao.getObject(statementName, parameterObject);
	}
	
	public Object insert(String statementName,Object parameterObject)
	{
		return sqlMapDao.insertObjects(statementName, parameterObject);
	}

	public int update(String statementName,Object parameterObject)
	{
		return sqlMapDao.updateObjects(statementName, parameterObject);
	}

	public int delete(String statementName,Object parameterObject)
	{
		return sqlMapDao.deleteObjects(statementName, parameterObject);
	}

}
