package main;
import entity.Student;
import utils.DBHibernate;
import utils.DBHibernateUtils;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException {


        Student student = new Student();
        student.setIdStudent(11);
        student.setName("Sasha");
        student.setIdGroup(2);
        student.setComingYear(2006);
        DBHibernate dbHibernate = new DBHibernate();
//        dbHibernate.save(student);
        dbHibernate.getAll().forEach(System.out::println);
    }
}
