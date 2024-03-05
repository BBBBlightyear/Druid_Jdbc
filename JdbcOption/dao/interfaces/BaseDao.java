package JdbcOption.dao.interfaces;

import JdbcOption.Utils.Druid_Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
// sql为查询语句，需要包括(?[,?])，使用parameters中的数据以向后顺序替代?，使用Druid连接池完成增删查改
public class BaseDao<T> {
    private QueryRunner qr =new QueryRunner();

    //增删使用update
    public  int updata(String sql,Object... parameters){
        Connection connection=null;

        try {
            connection= Druid_Utils.getConnection();
            int update =qr.update(connection,sql,parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Druid_Utils.close(null,null,connection);
        }
    }


    public List<T> queryMulti(String sql,Class<T> clazz, Object... parameters){
        Connection connection=null;

        try {
            connection= Druid_Utils.getConnection();
            return qr.query(connection,sql,new BeanListHandler<>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Druid_Utils.close(null,null,connection);
        }
    }

    public T querySingle(String sql,Class<T> clazz, Object... parameters){
        Connection connection=null;

        try {
            connection= Druid_Utils.getConnection();
            return qr.query(connection,sql,new BeanHandler<>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Druid_Utils.close(null,null,connection);
        }
    }
    public Object queryScalar(String sql, Object... parameters){
        Connection connection=null;

        try {
            connection= Druid_Utils.getConnection();
            return qr.query(connection,sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Druid_Utils.close(null,null,connection);
        }
    }



}
