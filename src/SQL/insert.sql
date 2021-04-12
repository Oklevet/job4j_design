create table users (
    id serial primary key,
    name varchar(2000)
);

create table role (
    id serial primary key,
    name varchar(2000),
    user_id int references users(id)
);

create table rules (
    id serial primary key,
    name varchar(2000)
);

create table role_rules (
    id serial primary key,
    name varchar(2000),
    role_id int references role(id),
    rule_id int references rules(id)
);

create table category (
    id serial primary key,
    name varchar(2000)
);

create table state (
    id serial primary key,
    name varchar(2000)
);

create table item (
    id serial primary key,
    name varchar(2000),
    user_id int references users(id),
    category_id int references category(id),
    state_id int references state(id)
);

create table comments (
    id serial primary key,
    name varchar(2000),
    item_id int references item(id)
);

create table attach (
    id serial primary key,
    name varchar(2000),
    item_id int references item(id)
);

insert into users (name) values ('Ivan');
insert into users (name) values ('Petr');
insert into users (name) values ('Vasya');

insert into role (name, user_id) values ('Employer', 
    (select id from users where name like ('Vasya')));
insert into role (name, user_id) values ('Customer', 
    (select id from users where name like ('Ivan')));
insert into role (name, user_id) values ('Employer', 
    (select id from users where name like ('Petr')));

insert into rules (name) values ('1st rule');
insert into rules (name) values ('2nd rule');
insert into rules (name) values ('3rd rule');

insert into role_rules (name, role_id, rule_id) values ('cust rules',
    (select id from role where name like ('Customer')),
    (select id from rules where name like ('1st rule')));
insert into role_rules (name, role_id, rule_id) values ('cust rules',
    (select id from role where name like ('Customer')),
    (select id from rules where name like ('2nd rule')));
insert into role_rules (name, role_id, rule_id) values ('emp rules',
    (select id from role where name like ('Employer')),
    (select id from rules where name like ('2nd rule')));
insert into role_rules (name, role_id, rule_id) values ('emp rules',
    (select id from role where name like ('Employer')),
    (select id from rules where name like ('3rd rule')));
    
select * from users
select * from role
select * from rules
select * from role_rules

