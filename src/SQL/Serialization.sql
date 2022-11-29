--psql -h 127.0.0.1 -U postgres
begin transaction isolation level serializable;
create table sales (
    id serial primary key,
    name varchar(50),
    price integer
);

insert into sales (name, price) VALUES ('sale1', 10);
insert into sales (name, price) VALUES ('sale2', 20);
insert into sales (name, price) VALUES ('sale3', 30);

select sum(price) from sales;

update sales set price = 100 where name = 'sale1';
update sales set price = 300 where name = 'sale3';


commit;