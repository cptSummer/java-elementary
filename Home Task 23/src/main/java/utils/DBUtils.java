package utils;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils implements StudentService {
    private static final String SERVER_TIME_ZONE = "UTC";
    private static final String SERVER_NAME = "localhost";
    private static final String DATABASE_NAME = "students";
    private static final int PORT_NUMBER = 3306;
    private static final String USER = "root";
    private static final String PASSWORD = "1111";


    public void addStudent(Student student) throws SQLException {
        MysqlDataSource dataSource = getMysqlDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into student(name,ID_Group,Coming_Year) " +
                        "values ( ?, ?,?)");

        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, student.getIdGroup());
        preparedStatement.setInt(3, student.getComingYear());
        preparedStatement.executeUpdate();

    }

    public void deleteStudent(int id) throws SQLException {
        MysqlDataSource dataSource = getMysqlDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("delete from student where ID_Student = ?");
        preparedStatement.setInt(1,id);
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
        dataSource.setServerTimezone(SERVER_TIME_ZONE);
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setPortNumber(PORT_NUMBER);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
