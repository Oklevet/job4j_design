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

select * from users
