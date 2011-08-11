package sg.edu.nus.iss.vms.common.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * @author zaw.htet
 *
 */
@SuppressWarnings("unchecked")
public class BaseDaoIbatis extends SqlMapClientDaoSupport implements SqlMapDao
{
	public Object getObject(String statementName)
	{
		return getSqlMapClientTemplate().queryForObject(statementName);
	}
	
	public Object getObject(String statementName, Object parameterObject)
	{
		return getSqlMapClientTemplate().queryForObject(statementName, parameterObject);
	}
	
	public List getObjects(String statementName)
	{
		return getSqlMapClientTemplate().queryForList(statementName);
	}

	public List getObjects(String statementName, Object parameterObject)
	{
		return getSqlMapClientTemplate().queryForList(statementName, parameterObject);
	}

	public Object insertObjects(String statementName, Object parameterObject)
	{
		return getSqlMapClientTemplate().insert(statementName, parameterObject);
	}
	
	public int updateObjects(String statementName,Object parameterObject)
	{
		return getSqlMapClientTemplate().update(statementName, parameterObject);
	}

	public int deleteObjects(String statementName, Object parameterObject)
	{
		return getSqlMapClientTemplate().delete(statementName, parameterObject);
	}
}
