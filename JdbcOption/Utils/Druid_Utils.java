package JdbcOption.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Druid_Utils {
    //定义一个静态的数据源
    static DataSource dataSource = null;

    //在静态代码块中读取文件,创建数据源
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("JdbcOption/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            System.out.println("连接池已创建");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //定义方法，返回连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //定义方法，取消连接的引用
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("连接引用已终止");
        } catch (Exception e) {
            System.out.println("连接关闭ERROR");;
        }
    }
}
