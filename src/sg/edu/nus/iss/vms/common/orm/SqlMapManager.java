package sg.edu.nus.iss.vms.common.orm;

import java.util.List;

import sg.edu.nus.iss.vms.common.dao.ibatis.SqlMapDao;

/**
 * @author zaw.htet
 *
 */
public interface SqlMapManager {

    public void setSqlMapDao(SqlMapDao dao);

    public Object get(String statementName);

    public Object get(String statementName, Object parameterObject);

    public List find(String statementName);

    public List find(String statementName, Object parameterObject);

    public Object insert(String statementName, Object parameterObject);

    public int update(String statementName, Object parameterObject);

    public int delete(String statementName, Object parameterObject);
}
