package main;
import com.mysql.cj.jdbc.MysqlDataSource;
import utils.DBUtils;
import utils.Student;

import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {


        DBUtils utils = new DBUtils();
        Student student = new Student().setName("Sasha").setIdGroup(2).setComingYear(2002);
//        utils.addStudent(student);
        utils.deleteStudent(5);
        utils.getALL().forEach(System.out::println);

    }
}
