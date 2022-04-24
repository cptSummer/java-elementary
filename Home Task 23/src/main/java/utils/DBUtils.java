package utils;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.SuspendableXAConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils implements StudentService {
    private static final String serverTimeZone = "UTC";
    private static final String serverName = "localhost"; // ip address db
    private static final String databaseName = "students"; // bd name
    private static final int portNumber = 3306; // db port
    private static final String user = "root"; // login
    private static final String password = "1111"; // password


    public void addStudent() throws SQLException {
        MysqlDataSource dataSource = getMysqlDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into student(ID_Student,name,ID_Group,Coming_Year) " +
                        "values (?, ?, ?,?)");
        List<String> studentName = List.of("Sasha", "Alex", "Masha", "Julia", "Artem");
        List<Integer> studentYear = List.of(2007,2016,2000,2002,1999);
        List<Integer> studentGroup = List.of(2,1,2,2,1);

        for (int i =1;i<studentName.size();i++){
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, studentName.get(i-1));
            preparedStatement.setInt(3, studentGroup.get(i-1));
            preparedStatement.setInt(4, studentYear.get(i-1));
            preparedStatement.executeUpdate();
        }

    }

    public void deleteStudent() throws SQLException {
        MysqlDataSource dataSource = getMysqlDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from student where name = ?");
        Scanner sc = new Scanner(System.in);
//        int id = sc.nextInt();
//        preparedStatement.setInt(1,id);
        String name = sc.nextLine();
        preparedStatement.setString(1,name);
        preparedStatement.executeUpdate();
    }

    public List<Student> getALL() throws SQLException {
        MysqlDataSource dataSource = getMysqlDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from student");
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int idGroup = rs.getInt(3);
            int comingYear = rs.getInt(4);


            students.add(new Student()
                    .setId(id)
                    .setName(name)
                    .setIdGroup(idGroup)
                    .setComingYear(comingYear)
            );

        }
        return students;
    }

    public List<Student> getByName(String name) throws SQLException {
        MysqlDataSource dataSource = getMysqlDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select name from student");
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            String stName = rs.getString(1);

            students.add(new Student().setName(stName));
        }
        return students;
    }

    public List<Student> getByIds(List<Integer> ids) throws SQLException {
        MysqlDataSource dataSource = getMysqlDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select ID_Student from student");
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);

            students.add(new Student().setId(id));
        }
        return students;
    }

    private MysqlDataSource getMysqlDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPortNumber(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
