create table meetings(
    id int primary key,
	"name" varchar
);

create table users(
    id int primary key,
	"name" varchar
);

create table requests(
    id int primary key,
    req_num varchar,
    status boolean,
    id_meet int references meetings(id),
    id_us int references users(id)
);

insert into meetings(id, name) values (1, 'room 1');
insert into meetings(id, name) values (2, 'room 2');
insert into meetings(id, name) values (3, 'room 3');
insert into meetings(id, name) values (4, 'room 4');
insert into users(id, name) values (101, 'Qwe');
insert into users(id, name) values (102, 'Asd');
insert into users(id, name) values (103, 'Zxc');
insert into users(id, name) values (104, 'Deq');
insert into users(id, name) values (105, 'Caca');
insert into users(id, name) values (106, 'Hoon');
insert into users(id, name) values (107, 'Uonp');
insert into requests(id, req_num, status, id_meet, id_us) values (1001, '5500R2', true, 2, 104);
insert into requests(id, req_num, status, id_meet, id_us) values (1002, '5500R2', true, 2, 105);
insert into requests(id, req_num, status, id_meet, id_us) values (1003, '5500R3', true, 3, 104);
insert into requests(id, req_num, status, id_meet, id_us) values (1004, '5500R4', false, 4, 104);
insert into requests(id, req_num, status, id_meet, id_us) values (1005, '5500R2', true, 2, 101);
insert into requests(id, req_num, status, id_meet, id_us) values (1006, '5500R3', false, 3, 102);
insert into requests(id, req_num, status, id_meet, id_us) values (1007, '5500R4', true, 4, 102);
insert into requests(id, req_num, status, id_meet, id_us) values (1008, '5500R2', false, 2, 107);
insert into requests(id, req_num, status, id_meet, id_us) values (1009, '5500R2', false, 2, 106);
insert into requests(id, req_num, status, id_meet, id_us) values (1010, '5500R2', true, 2, 105);

select * from meetings;
select * from users;
select * from requests;

--Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.
select  r.req_num, count(r.id_us)
from    requests r
where   r.status = true 
group by r.req_num

--Нужно получить все совещания, где не было ни одной заявки на посещения
--1
select  m.*
from    meetings m
where not exists (
        select  *
        from  requests r
        where  m.id = r.id_meet
        );
        
--2        
select  m.*
from    meetings m
left outer join requests r
on m.id = r.id_meet
except  
select  m.*
from    meetings m
right  outer join requests r
on m.id = r.id_meet