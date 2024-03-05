package JdbcOption.dao;



import JdbcOption.domain.Group;
import JdbcOption.dao.interfaces.BaseDao;
import druid_JDBC_utils.Druid_Utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Group_dao extends BaseDao<Group> {
    public int G_signUp(String TID, String UID,String Work_labor,String CID) {
        try {
            String str = "INSERT INTO contest_info(CID,C_name,C_level,C_class) values(?,?,?,?) ";
            List<Group> ct = seek(TID, UID);
            if (ct != null) {
                System.out.println("已存在");
                return 0;
            } else {
                return super.updata(str,TID, UID, Work_labor, CID);
            }
        } catch (Exception e) {
            System.out.println("注册失败");
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------查询队伍表-----------------------------------------------//
    public List<Group> seek(String TID, String UID) {
        try {
            String str ;
            str="SELECT * FROM contest_info Where (TID=? or ?='null') and （UID=? or ?='null') ";
            List<Group> con= super.queryMulti(str,Group.class,TID,TID ,UID,UID );
            if (con==null) {
                System.out.println("用户不存在");
                return null;
            } else {
                System.out.println(con);
                System.out.println("搜索成功");
            }
            return con;
        } catch (Exception e) {
            System.out.println("获取table失败");
            throw new RuntimeException(e);
        }

    }
    public int drop(String TID,String UID) {
        try {
            String str = "DELETE FROM group_table Where TID=? and UID=? ";
            List<Group> ct = seek(TID,UID);
            if (ct==null) {
                System.out.println("不存在");
                return 0;
            } else {
                return super.updata( str,TID,UID);
            }
        } catch (Exception e) {
            System.out.println("删除失败");
            throw new RuntimeException(e);
        }


    }

    //通过group_table查询返回队员的学号列表
    public static List<String> return_people_id(String leader_id){
     List<String> list=new ArrayList<String>();
     Connection connection=null;
     PreparedStatement preparedStatement=null;
     ResultSet resultSet=null;
     try {
         String sql="select UID from link_team.group_table where TID=?";
         connection= Druid_Utils.getConnection();
         preparedStatement=connection.prepareStatement(sql);
         preparedStatement.setString(1,leader_id);
         resultSet=preparedStatement.executeQuery();
         while (resultSet.next()){
             list.add(resultSet.getString("UID"));
         }
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
     finally {
         Druid_Utils.close(resultSet,preparedStatement,connection);
     }
     return list;
    }


}
