package utils;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws SQLException;
    void deleteStudent(int id) throws SQLException;
    List<Student> getALL() throws SQLException;
    List<Student> getByName(String name) throws SQLException;
    List<Student> getByIds(List<Integer> ids) throws SQLException;
}
