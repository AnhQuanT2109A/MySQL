create database Phim;
use Phim;

create table dsPhim(
    id int primary key,
    TenPhim varchar(50),
    ThoiGianChieu DATE,
    TenDaoDien varchar(50),
    ThoiGian int
);
insert into dsPhim values(1, 'Mat Biec', '2022-01-01', 'Victor Vu', 120);
insert into dsPhim values(2, 'Spiderman', '2012-04-12', 'Jon Watts', 120);
insert into dsPhim values(3, 'Bac Kim Thang', '2019-11-01', 'Victor Vu', 120);
insert into dsPhim values(4, 'Minion', '2012-01-01', 'Jonh', 120);
insert into dsPhim values(5, 'Nguoi bat tu', '2022-01-01', 'Dang Kim Thi', 110);

select * from dsPhim;
drop table dsPhim;
