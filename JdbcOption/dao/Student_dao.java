package JdbcOption.dao;
import JdbcOption.dao.interfaces.BaseDao;
import db.logical_op;
import JdbcOption.domain.PageBean;
import JdbcOption.domain.Student;

import java.util.List;

public class Student_dao extends BaseDao<Student> {

    //---------------------------------------登录-----------------------------------------------//
    public boolean login(String UID, String password) {
        try {
            String str;
            if (UID == null||password==null) {
                System.out.println("用户名或密码为空");
                return false;
            }
            str = "SELECT * FROM student_info WHERE UID=?";
            Student st = (Student) super.queryScalar(str,UID,password);

            if (st==null) {
                System.out.println("用户不存在");
                return false;
            } else {
                System.out.println(st);
                System.out.println("搜索成功");
                return true;
            }
        } catch (Exception e) {
            System.out.println("获取table失败");
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------用户注册---------------------------------------------//

    public int signUp(String UID, String password, String UName, String Student_ID, String Student_Name, String Tel) {
        try {
            List<Student> st = seek(UID);
            if (st!=null) {
                System.out.println("用户已存在");
                return 0;
            } else {
                String tem = "INSERT INTO student_info (UID,password,UName,Student_ID,Student_Name,Tel) VALUES (?,?,?,?,?,?) ";
                return super.updata(tem,UID,password,UName,Student_ID,Student_Name,Tel);
            }
        } catch (Exception e) {
            System.out.println("注册失败");
            throw new RuntimeException(e);
        }
    }

    //--------------------------------------信息补全------------------------------------------------//
    public int updata(String UID, String requirement, String Strong_point, String Grade, String Major) {
        try {
            String str = "SELECT * FROM student_info WHERE UID=? ";
            List<Student> st = seek(UID);
            if (st==null) {
                System.out.println("用户不存在");
                return 0;
            } else {
                String tem = "updata student_info set requirement=?,Strong_point=?,Grade=?,Major=? where UID=? ";
                return super.updata(tem,UID,requirement, Strong_point,Grade, Major);
            }
        } catch (Exception e) {
            System.out.println("注册失败");
            throw new RuntimeException(e);


    }

    //--------------------------------------打印学生信息-----------------------------------------------//
    public List<Student> seek(String UID) {
        try {
            String str;
            str = "SELECT * FROM student_info WHERE (UID=? OR ?='null')";

            List<Student> st = super.queryMulti(str,Student.class,UID,UID);

            if (st==null) {
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

    public int drop(String UID) {
        try {
            String str = "DELETE FROM student_info Where UID=? ";
            List<Student> ct = seek(UID);
            if (ct==null) {
                System.out.println("不存在");
                return 0;
            } else {
                return super.updata( str,UID);
            }
        } catch (Exception e) {
            System.out.println("删除失败");
            throw new RuntimeException(e);
        }


    }

    //分页查询第一步——————————————by SPC
    public static PageBean<Student> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition,String id) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0){//当前页小于0，则设置为1
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageBean<Student> pb = new PageBean<Student>();

        //2.查询总记录数
        int totalCount =db.logical_op.findTotalCount(condition,"student_info",id);
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
        List<Student> list =logical_op.findByPage_student(start,rows,condition,id);
        pb.setList(list);

        return pb;
    }

    //分页查询认证表——————————————by SPC
    public static PageBean<Student> findUserByPage_Manager(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0){//当前页小于0，则设置为1
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageBean<Student> pb = new PageBean<Student>();

        //2.查询总记录数
        int totalCount =db.logical_op.findTotalCount(condition,"students",null);
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
        List<Student> list =logical_op.findByPage_manager(start,rows,condition);
        pb.setList(list);

        return pb;
    }
}


