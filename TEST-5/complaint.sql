create database cr;
use cr;

Create Table Complaint
(
   ComplaintID varchar(30) primary key,
   ComplaintType varchar(30),
   CDescription varchar(100),
   ComplaintDate date,
   Severity varchar(20),
   Status varchar(30) default 'Pending'
);




Create Table Resolve
(
   ComplaintID varchar(30),
   ComplaintDate date,
   ResolveDate date,
   ResolvedBy varchar(30),
   Comments varchar(100)
);

Insert into cr.complaint(ComplaintID, ComplaintType, CDescription,ComplaintDate,Severity,Status)
values(1, 'keyboard not working',' Keyboard not working', '2020-10-21','bad condition','Pending'),
(2, 'Internet Connection','Internet connectivity is not getting on', '2020-10-20','Unable to work','Pending'),
(3, 'PC not starting','PC is not getting on ', '2020-11-01','Hanged','Pending'),
(4, 'Not getting charged','PC not getting charged even after connecting plug', '2020-12-10','Dead','Pending');
