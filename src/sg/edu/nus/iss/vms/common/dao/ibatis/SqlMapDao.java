package sg.edu.nus.iss.vms.common.dao.ibatis;

import java.util.List;

/**
 * @author zaw.htet
 *
 */
public interface SqlMapDao
{
	public Object getObject(String statementName);
	
	public Object getObject(String statementName, Object parameterObject);
	
	public List   getObjects(String statementName);

	public List   getObjects(String statementName, Object parameterObject);
	
	public Object insertObjects(String statementName,Object parameterObject);
	
	public int updateObjects(String statementName,Object parameterObject);
	
	public int deleteObjects(String statementName,Object parameterObject);
}
