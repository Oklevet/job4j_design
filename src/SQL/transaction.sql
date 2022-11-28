start transaction isolation level read committed;
commit;

begin transaction;

create table sales (
    id serial primary key,
    "name" varchar(50),
    price integer,
    status varchar(10)
);

savepoint sales_new_tab;

insert into sales (name, price, status) VALUES ('sale1`', 100, 'new');
insert into sales (name, price, status) VALUES ('sale2`', 150, 'used');
insert into sales (name, price, status) VALUES ('sale3`', 300, 'new');

select * from sales;

savepoint first_insert;

insert into sales (name, price, status) VALUES ('sale2`', 222, 'used');
insert into sales (name, price, status) VALUES ('sale3`', 200, 'new');

select * from sales;

savepoint second_insert;

insert into sales (name, price, status) VALUES ('sale3`', 444, 'new');

select * from sales;

rollback to first_insert;

select * from sales;

insert into sales (name, price, status) VALUES ('sale3`', 666, 'new');

select * from sales;

rollback;

select * from sales;        --call error, table sales not exists