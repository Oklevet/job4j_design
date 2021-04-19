drop table cars;
drop table body;
drop table engine;
drop table transmission;

create table body(
	id serial primary key,
	elements varchar
);

create table engine(
	id serial primary key,
	elements varchar
);

create table transmission(
	id serial primary key,
	elements varchar
);

create table cars(
	id serial primary key,
	model varchar,
	elem_b_id int references body(id),
	elem_e_id int references engine(id),
	elem_t_id int references transmission(id)
);

insert into body(elements) values ('door');
insert into body(elements) values ('hood');
insert into body(elements) values ('window');
insert into body(elements) values ('tail');
insert into body(elements) values ('spoiler');
insert into engine(elements) values ('nozzles');
insert into engine(elements) values ('pulley');
insert into engine(elements) values ('pusher');
insert into engine(elements) values ('cylinder liner');
insert into transmission(elements) values ('pump');
insert into transmission(elements) values ('planetary reductor');
insert into transmission(elements) values ('oil receiver');
insert into transmission(elements) values ('clutch');
insert into transmission(elements) values ('torque converter');
insert into transmission(elements) values ('propeller');


insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Ferrari', 1, 2, 1);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Ferrari', 2, 3, 2);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Ferrari', 3, 4, 3);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Ferrari', 5, null, 4);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Ferrari', null, null, 5);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Lada', 1, 2, 1);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Lada', 2, 3, 2);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Lada', 3, 4, 3);
insert into cars(model, elem_b_id, elem_e_id, elem_t_id) values ('Lada', 5, null, 4);

select * from body
select * from engine
select * from transmission
select * from cars

select c.model, b.elements, e.elements, t.elements
    from cars c left join body b on c.elem_b_id = b.id
                left join engine e on c.elem_e_id = e.id
                left join transmission t on c.elem_t_id = t.id

select b.id, b.elements from cars c right outer join body b on c.elem_b_id = b.id
where c.id is null

select e.id, e.elements from cars c right outer join engine e on c.elem_b_id = e.id
where c.id is null

select t.id, t.elements from cars c right outer join transmission t on c.elem_b_id = t.id
where c.id is null