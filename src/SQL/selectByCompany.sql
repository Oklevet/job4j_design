CREATE TABLE company
(
    id integer NOT NULL,
    "name" character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    "name" character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
        
insert into company(id, name) values (1, 'comp 1');
insert into company(id, name) values (2, 'comp 2');
insert into company(id, name) values (3, 'comp 3');
insert into company(id, name) values (4, 'comp 4');
insert into company(id, name) values (5, 'comp 5');

insert into person(id, name, company_id) values (101, 'pers 1', 2);
insert into person(id, name, company_id) values (102, 'pers 2', 3);
insert into person(id, name, company_id) values (103, 'pers 3', 5);
insert into person(id, name, company_id) values (104, 'pers 4', 1);
insert into person(id, name, company_id) values (105, 'pers 5', 2);
insert into person(id, name, company_id) values (106, 'pers 6', 1);
insert into person(id, name, company_id) values (107, 'pers 7', 3);
insert into person(id, name, company_id) values (108, 'pers 8', 4);

select * from person;
select * from company;

/* имена всех person, которые не состоят в компании с id = 5;
- название компании для каждого человека.*/

select  p.name, c.name company 
from    person p
        ,company c
where   p.company_id != 5
        and c.id = p.company_id

/*2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.*/

select   c.name company, count(p.name) 
from     person p
         ,company c
where    c.id = p.company_id
group by c.name
order by count(p.name) desc, c.name
limit 1