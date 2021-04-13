drop table musician;
drop table genre;

create table genre(
     id serial primary key,
     name varchar(255)
 );

create table musician(
     id serial primary key,
     name varchar(255),
     position_id int references genre(id)
 );

insert into genre(name) values('hard rock');
insert into genre(name) values('k-pop');
insert into genre(name) values('pop');

insert into musician(name, position_id) values ('AC/DC', 1);
insert into musician(name, position_id) values ('katy perri', 3);
insert into musician(name, position_id) values ('blackpink', 2);
insert into musician(name, position_id) values ('godsmack', 1);
insert into musician(name) values ('other');

select * from musician
select * from genre

select * from musician as m join genre g on m.position_id = g.id;
select m.name, g.name from musician as m join genre g on m.position_id = g.id
	where g.name like '%rock';
select m.name, g.name from musician as m join genre g on m.position_id = g.id
	where g.name like '%pop%';