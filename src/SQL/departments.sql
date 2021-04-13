create table departments(
    id serial primary key,
    name varchar(255)
);

create table employes(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('Department 1');
insert into departments(name) values ('Department 2');
insert into departments(name) values ('Department 3');
insert into departments(name) values ('Department 4');

insert into employes(name, department_id) values ('Qwe Qwe', 1);
insert into employes(name, department_id) values ('Asd Asd', 2);
insert into employes(name, department_id) values ('Zxc Zxc', 3);
insert into employes(name, department_id) values ('Qweasd Fgh', null);
insert into employes(name, department_id) values ('Qwerty Zxcd', null);
insert into employes(name, department_id) values ('Iop Jikf', 1);

select * from departments d left join employes e on d.id = e.department_id
select * from departments d right join employes e on d.id = e.department_id
select * from departments d full join employes e on d.id = e.department_id
select * from departments d cross join employes e

select * from departments d left join employes e on d.id = e.department_id where e.name is null

select * from departments d right join employes e on d.id = e.department_id
select * from employes e left join departments d on d.id = e.department_id

create table teens(
    id serial primary key,
    name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('Mia', 'F');
insert into teens(name, gender) values ('Ria', 'F');
insert into teens(name, gender) values ('Tink', 'M');
insert into teens(name, gender) values ('Link', 'M');
insert into teens(name, gender) values ('Lia', 'F');
insert into teens(name, gender) values ('Nik', 'M');
insert into teens(name, gender) values ('Sia', 'F');

select * from teens t1 cross join teens t2 where t1.gender != t2.gender