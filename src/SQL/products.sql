drop table product;
drop table type;

create table type (
	id serial primary key,
    name varchar(255)
); 

create table product(
	id serial primary key,
    name varchar(255),
	type_id int references type(id),
    expired_date date,
	price float
);
insert into type(name) values ('CHEESE');
insert into type(name) values ('MILK');
insert into type(name) values ('MEAT');
insert into type(name) values ('VANILLA ICECREAM');

insert into product(name, type_id, expired_date, price) values ('Lamber', 1, '20/04/2021', 800);
insert into product(name, type_id, expired_date, price) values ('Russian', 1, '01/05/2021', 500);
insert into product(name, type_id, expired_date, price) values ('Belster', 1, '20/05/2021', 1100);
insert into product(name, type_id, expired_date, price) values ('NeMoloko', 2, '12/05/2021', 110);
insert into product(name, type_id, expired_date, price) values ('Pralamat', 2, '20/06/2021', 100);
insert into product(name, type_id, expired_date, price) values ('Beef', 3, '31/05/2021', 500);
insert into product(name, type_id, expired_date, price) values ('Pork', 3, '24/04/2021', 350);
insert into product(name, type_id, expired_date, price) values ('Eskimo', 4, '28/04/2021', 80);
insert into product(name, type_id, expired_date, price) values ('Berry icecream', 4, '28/04/2021', 80);

select * from type
select * from product

select * 
	from product p,
		type t
	where t.id = p.type_id
		and t.name like 'CHEESE';

select * 
	from product p,
		type t
	where t.id = p.type_id
		and p.name like ('%icecream%');

select *
	from product p
	where date_part('month', p.expired_date)
	       = date_part('month', now() + interval '1 month');

select p.id, p.name, max(p.price)
	from product p
	group by p.id
	order by p.price desc
	limit 1
	
select t.name, count(p.type_id) quantity
	from product p,
		type t
	where t.id = p.type_id
	group by t.name
	
select * 
	from product p,
		type t
	where t.id = p.type_id
	and t.name in ('CHEESE', 'MILK');

-- Instead 10 was taken 3 to read visual changes in the query results.
select t.name, count(p.type_id) quantity
		from product p,
			type t
		where t.id = p.type_id
		group by t.name
		having count(p.type_id) < 3;
