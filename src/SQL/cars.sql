drop table body;
drop table engine;
drop table transmission;

create table cars(
	id serial primary key,
	model varchar
);

create table body(
	id serial primary key,
	elements varchar,
	car_id int references cars(id)
);

create table engine(
	id serial primary key,
	elements varchar,
	car_id int references cars(id)
);

create table transmission(
	id serial primary key,
	elements varchar,
	car_id int references cars(id)
);

insert into cars(model) values ('Ferrari');
insert into cars(model) values ('Lada');

insert into body(elements, car_id) values ('door', 2);
insert into body(elements, car_id) values ('hood', 2);
insert into body(elements, car_id) values ('window', 2);
insert into body(elements, car_id) values ('tail', null);
insert into body(elements, car_id) values ('spoiler', 1);
insert into body(elements, car_id) values ('door', 1);
insert into body(elements, car_id) values ('hood', 1);
insert into body(elements, car_id) values ('window', 2);
insert into engine(elements, car_id) values ('pulley', 2);
insert into engine(elements, car_id) values ('pusher', 2);
insert into engine(elements, car_id) values ('cylinder liner', 2);
insert into engine(elements, car_id) values ('nozzles', null);
insert into engine(elements, car_id) values ('pulley', 1);
insert into engine(elements, car_id) values ('pusher', 1);
insert into engine(elements, car_id) values ('cylinder liner', 1);
insert into transmission(elements, car_id) values ('pump', 2);
insert into transmission(elements, car_id) values ('planetary reductor', 2);
insert into transmission(elements, car_id) values ('oil receiver', 2);
insert into transmission(elements, car_id) values ('clutch', 2);
insert into transmission(elements, car_id) values ('torque converter', 2);
insert into transmission(elements, car_id) values ('pump', 1);
insert into transmission(elements, car_id) values ('planetary reductor', 1);
insert into transmission(elements, car_id) values ('oil receiver', 1);
insert into transmission(elements, car_id) values ('clutch', 1);
insert into transmission(elements, car_id) values ('torque converter', 1);

select * from body
select * from engine
select * from transmission

select *
from (
	select c.model, b.elements 
		from cars c,
			body b 
		where c.id = b.car_id
	union
	select c.model, e.elements 
		from cars c,
			engine e 
		where c.id = e.car_id
	union
	select c.model, t.elements 
		from cars c,
			transmission t 
		where c.id = t.car_id
) a
order by a

select * from body b where b.car_id is null
select * from engine e where b.car_id is null
select * from transmission t where b.car_id is null