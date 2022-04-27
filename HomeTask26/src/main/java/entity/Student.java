package entity;


import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Student")
    private int idStudent;
    @Column(name = "name")
    private String name;
    @Column(name = "ID_Group")
    private int idGroup;
    @Column(name = "Coming_Year")
    private int comingYear;

    public Student() {
    }

    public Student(int idStudent, String name, int idGroup, int comingYear) {
        this.idStudent = idStudent;
        this.name = name;
        this.idGroup = idGroup;
        this.comingYear = comingYear;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getComingYear() {
        return comingYear;
    }

    public void setComingYear(int comingYear) {
        this.comingYear = comingYear;
    }

    @Override
    public String toString() {
        return "Student" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", idGroup=" + idGroup +
                ", comingYear=" + comingYear;
    }
}
