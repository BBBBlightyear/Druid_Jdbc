package JdbcOption;

import JdbcOption.dao.Student_dao;

public class test {
    public static void main(String[] args) {
        try {
            Student_dao a =new Student_dao();
            a.seek("null");
        }catch (Exception e){
            System.out.println("false");
        }
    }
}
