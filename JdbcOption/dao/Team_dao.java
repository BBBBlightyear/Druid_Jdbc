package JdbcOption.dao;
import JdbcOption.dao.interfaces.BaseDao;
import druid_JDBC_utils.Druid_Utils;

import JdbcOption.domain.PageBean;
import JdbcOption.domain.Team;
import db.logical_op;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class Team_dao extends BaseDao<Team> {
//    public boolean T_signUp( String TName, String UID_Leader, String Start_time, String End_time, String Max_num, String Exist_num, String Introduct) {
//        try {
//            List<Team> st = seek(TID);
//            if (st!=null) {
//                System.out.println("用户已存在");
//                return false;
//            } else {
//                String tem = "INSERT INTO team_table (TID, TName, Introduction,Max_num, Exist_num,Student_ID_leader) VALUES (?,?,?,?,?,?,?,?) ";
//                return super.update(TID, TName,UID_Leader,Start_time,End_time, Max_num,  Exist_num, Introduct);
//            }
//        } catch (Exception e) {
//            System.out.println("注册失败");
//            throw new RuntimeException(e);
//        }
//    }

    //--------------------------------------打印队伍信息-----------------------------------------------//
    public List<Team> seek(String TID) {
        try {
            String str;
            str = "SELECT * FROM student_info WHERE (UID=? OR ?='null')";

            List<Team> st = super.queryMulti(str, Team.class, TID, TID);

            if (st == null) {
                System.out.println("用户不存在");
                return null;
            } else {
                System.out.println(st);
                System.out.println("搜索成功");
            }
            return st;
        } catch (Exception e) {
            System.out.println("获取table失败");
            throw new RuntimeException(e);
        }
    }
    public int drop(String TID) {
        try {
            String str = "DELETE FROM team_table Where TID=? ";
            List<Team> ct = seek(TID);
            if (ct==null) {
                System.out.println("不存在");
                return 0;
            } else {
                return super.updata( str,TID);
            }
        } catch (Exception e) {
            System.out.println("删除失败");
            throw new RuntimeException(e);
        }


    }

    //分页查询第一步——————————————by SPC
    public static PageBean<Team> findTeamByPage(String _currentPage, String _rows, Map<String, String[]> condition, String id) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0){//当前页小于0，则设置为1
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageBean<Team> pb = new PageBean<Team>();

        //2.查询总记录数
        int totalCount =db.logical_op.findTotalCount(condition,"team_table",id);
        System.out.println("总计记录数为"+totalCount);
        if(totalCount==0){
            return null;
        }
        pb.setTotalCount(totalCount);


        //3.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //4.计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount/rows) : (totalCount/rows) +1;
        pb.setTotalPage(totalPage);

        if(currentPage >= totalPage){//当前页大于最大页，则设置为totalCount
            currentPage = totalPage;
        }

        //5.查询List集合
        //计算开始的记录
        int start = (currentPage - 1) * rows;
        List<Team> list = logical_op.findByPage_team(start,rows,condition,id);
        pb.setList(list);

        return pb;
    }

    public static Team showMyTeam(String id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Team team=null;
        String sql="select * from link_team.team_table where Student_ID_leader='"+id+"'";
       try {
           connection=Druid_Utils.getConnection();
           preparedStatement=connection.prepareStatement(sql);
           resultSet=preparedStatement.executeQuery();
           resultSet.next();
           //String TName, String introduction, String start_time, int exist_num, String UID_leader
           team=new Team(resultSet.getString("TName"),resultSet.getString("Introduction"),
                   resultSet.getString("Start_time"),Integer.parseInt(resultSet.getString("Exist_Num")),
                   resultSet.getString("Student_ID_leader"));
       }
       catch (Exception e){
           throw new RuntimeException(e);
       }
       finally {
           Druid_Utils.close(resultSet,preparedStatement,connection);
       }
       return team;
    }
}
