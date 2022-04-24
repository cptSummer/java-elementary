package main;
import com.mysql.cj.jdbc.MysqlDataSource;
import utils.DBUtils;
import utils.Student;

import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {


        DBUtils utils = new DBUtils();
//        utils.addStudent();
        utils.getALL().forEach(System.out::println);

    }
}
