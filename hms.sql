drop database if exists HMS;
create database HMS;  
-- drop database if exists HMS;
use HMS; 
-- drop table if exists DOCTOR_MASTER;
-- drop table if exists ROOM_MASTER;
-- drop table if exists PATIENT_MASTER; 
-- drop table if exists ROOM_ALLOCATION; 


-- pid,name, doctor_id, doctor_name, room_no, room_type and admission_date. (doc id,doc name)
create table DOCTOR_MASTER(
doctor_id  varchar(30) not null,
doctor_name varchar(30 )not null,
Dept varchar(30)not null  , 
primary key(doctor_id)
);  
-- id,patient_name, doctor_id, doctor_name, room_no, room_type and admission_date.(room_no as primary,room type)
create table ROOM_MASTER 
(room_no varchar(20), 
primary key(room_no),
 room_type varchar(20) not null,
 status  varchar(20)not null
 );  
-- id,patient_name, doctor_id, doctor_name, room_no, room_type and admission_date.(pid,name,doc id)
create table PATIENT_MASTER 
(
pid varchar(25),  
primary key (pid),
name varchar(30)not null,
age numeric not null,
weight numeric not null,
gender varchar(8)not null,
address varchar(30) not null,
phoneno numeric not null,
disease varchar(25)not null,
doctor_id varchar(30) not null,
foreign key (doctor_id) references  DOCTOR_MASTER(doctor_id)
); 
-- id,patient_name, doctor_id, doctor_name, room_no, room_type and admission_date.(room no fkey,pid fkey,ad date)
create table ROOM_ALLOCATION
(room_no varchar(20),
 pid varchar(25),
 admission_date date ,
 release_date date ,
 foreign key(room_no) references ROOM_MASTER(room_no),
 foreign key(pid) references PATIENT_MASTER(pid)
 );   
 insert into DOCTOR_MASTER (doctor_id ,doctor_name ,Dept)  
Values('D0001','Ram','ENT'),
('D0002','Rajan','ENT'),
('D0003','Smita','Eye'),
('D0004','Bhavan','Surgery'),
('D0005','Sheela','Surgery'),
('D0006','Nethra','Surgery');  
  insert into  ROOM_MASTER(room_no,room_type ,status) 
  VALUES('R0001','AC','occupied'),
        ('R0002','Suite','vacant'),
	   ('R0003','NonAC','vacant'),
       ('R0004','NonAC','occupied'),
       ('R0005','AC','vacant'),
         ('R0006','AC','occupied');
insert into PATIENT_MASTER(pid,name ,age ,weight  ,gender ,address ,phoneno ,disease ,doctor_id ) 
Values( 'P0001','Gita','35','65','F','Chennai','9867145678','Eye Infection','D0003'),
('P0002','Ashish','40','70','M','Delhi','9845675678','Asthma','D0003'),
('P0003','Radha','25','60','F','Chennai','9867166678','Pain in heart','D0005'),
('P0004','Chandra','28','55','F','Bangalore','9978675567','Asthma','D0001'),
('P0005','Goyal','42','65','M','Delhi','8967533223','Pain in Stomach','D0004');

 insert into  ROOM_ALLOCATION (room_no , pid ,admission_date  ,release_date ) 
 values ( 'R0001','P0001','15-08-16','26-08-16'),
('R0002','P0002','15-11-16','26-11-16'),
('R0002','P0003','01-12-16','30-12-16'); 






-- *********************************ANSWERS*************************
select pid from ROOM_ALLOCATION;  

use hms;

select gender from PATIENT_MASTER ;

select gender,count('M') 
from PATIENT_MASTER; 

select gender,count('f')
from PATIENT_MASTER;

select gender ,count('M'),count('F')
from PATIENT_MASTER; 

Select room_no,count('NULL')
from ROOM_MASTER; 

select room_no, room_type  
FROM ROOM_MASTER where count(room_no>1);


select * from ROOM_ALLOCATION; 
select* from ROOM_ALLOCATION where monthname(admission_date)='December'; 
select* from ROOM_ALLOCATION where monthname(admission_date)='January'; 



select room_no 
from ROOM_ALLOCATION 
group by room_no 
having count(room_no)>1; 




SELECT room_no,room_type
from ROOM_MASTER
where room_no in( select room_no from room_allocation group by room_no HAVING count(room_no)>1); 
 select *  from PATIENT_MASTER where disease not like 'Asthma'; 
 
 
 
 SELECT P.doctor_id,doctor_name,name,room_no ,
 R.pid, admission_date
 FROM PATIENT_MASTER P INNER JOIN DOCTOR_MASTER D ON
 P.doctor_id=D.doctor_id
 INNER JOIN ROOM_ALLOCATION R on 
 R.pid=P.pid;