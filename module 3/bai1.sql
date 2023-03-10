create database student_management;
use student_management;
create table class(
  id_class int not null,
  name_class varchar(50)
);
create table teacher(
  id_teacher int not null,
  name_teacher varchar(30),
  age int not null,
  country varchar(30)
);