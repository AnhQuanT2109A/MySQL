CREATE DATABASE test1;
USE test1;
create TABLE ta1(
	id int,
    name varchar(30)
);
INSERT INTO ta1 VALUES(1,'Anh Quan');
INSERT INTO ta1 VALUES(2,'Anh Quan1');
INSERT INTO ta1 VALUES(3,'Anh Quan2');
INSERT INTO ta1 VALUES(4,'Anh Quan3');
SELECT * FROM `ta1` WHERE 1;