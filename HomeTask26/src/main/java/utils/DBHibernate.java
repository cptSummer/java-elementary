package utils;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public class DBHibernate implements HiberStudentServ{

    @Override
    public void save(Student student) {
        Session session = DBHibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = DBHibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) DBHibernateUtils.getSessionFactory().openSession().createQuery("From Student").list();
    }

    @Override
    public List<Student> getByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Student student : getAll()) {
            if (student.getName().equals(name)) {
                students.add(student);
            }
        }
        return students;

    }

    @Override
    public Student getByIds(int ids) {
        return (Student) DBHibernateUtils.getSessionFactory().openSession().get(Student.class, ids);
    }
}
