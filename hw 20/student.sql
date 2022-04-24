create database students;
use students;

create table student(
ID_Student int not null auto_increment,
name varchar(300) not null,
ID_Group int not null,
Coming_Year int not null,
constraint ID_Student primary key(ID_Student)
);

create table group_student(
ID_Group int not null auto_increment,
name varchar(30) not null,
constraint ID_Group primary key(ID_Group)
);

create table mark(
ID_Mark int not null ,
ID_Science int not null,
ID_Student int not null,
mark int not null,
constraint ID_Mark primary key(ID_Mark)
);

create table science (
ID_Science int not null auto_increment,
name varchar(30) not null,
ID_Teacher int not null,
year int not null,
semester int not null,
constraint ID_Science primary key(ID_Science)
);

create table teacher(
ID_Teacher int not null auto_increment,
name varchar(300) not null,
ID_Department int not null,
constraint ID_Teacher primary key(ID_Teacher)
);

create table deapartment(
ID_Department int not null auto_increment,
name varchar(30) not null ,
manager varchar(30) not null,
constraint ID_Department primary key(ID_Department)
);

/* один-ко-многим СТУДЕНТЫ-ГРУППЫ */
SELECT student.ID_Student,
student.name,
student.ID_Group,
group_student.name
FROM student
LEFT JOIN group_student
ON student.ID_Student = group_student.ID_Group;

/* один-ко-многим СТУДЕНТЫ-БАЛЛЫ */
SELECT student.ID_Student,
student.name,
student.ID_Group,

mark.ID_Mark,
mark.ID_Science,
mark.mark
FROM mark
RIGHT JOIN student
ON mark.ID_Student = student.ID_Student;

SELECT science.ID_Science,
science.name,
science.ID_Teacher,

mark.ID_Science
FROM mark
LEFT JOIN science
ON mark.ID_Science = science.ID_Science;

SELECT science.ID_Science,
science.name,
science.ID_Science,

teacher.ID_Teacher,
teacher.name,
teacher.ID_Department
FROM science
LEFT JOIN teacher
ON science.ID_Science = teacher.ID_Teacher;

SELECT teacher.ID_Teacher,
teacher.name,

teacher.ID_Teacher,

deapartment.name,
deapartment.manager
FROM teacher
LEFT JOIN deapartment
ON teacher.ID_Teacher = deapartment.ID_Department;