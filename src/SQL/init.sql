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

create table item (
    id serial primary key,
    name varchar(2000)
);

create table comments (
    id serial primary key,
    name varchar(2000)
);

create table attach (
    id serial primary key,
    name varchar(2000)
);

create table category (
    id serial primary key,
    name varchar(2000)
);

create table state (
    id serial primary key,
    name varchar(2000)
);