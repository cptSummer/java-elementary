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

alter table student add constraint fk_student
foreign key(ID_Group) references group_student(ID_Group);

alter table mark add constraint fk_mark
foreign key(ID_Student) references student(ID_Student);

alter table mark 
change ID_Science science int not null;

alter table mark add constraint fk_mark_1
foreign key(science) references science (ID_Science);

alter table mark
  change science ID_Science int not null;
  
alter table science add constraint fk_science
foreign key(ID_Teacher) references teacher(ID_Teacher);

alter table teacher
change id_department id_department int not null;

alter table deapartment
modify id_department bigint not null;

alter table deapartment
modify id_department int not null;

alter table deapartment
  modify id_department int not null auto_increment;
  
alter table teacher add constraint fk_teacher
foreign key(ID_Department) references deapartment (ID_Department);