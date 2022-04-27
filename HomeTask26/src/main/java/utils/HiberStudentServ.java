package utils;

import entity.Student;

import java.util.List;

public interface HiberStudentServ {

    void save(Student student);
    void delete(Student student);
    List<Student> getAll();
    List<Student> getByName(String name);
    Student getByIds(int ids);
}
