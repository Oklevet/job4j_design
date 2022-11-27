create table students(
    id serial primary key,
    "name" varchar(50)
);

insert into students (name) values ('Иван Иванов');
insert into students (name) values ('Петр Петров');

create table authors(
    id serial primary key,
    "name" varchar(50),
    country varchar(50)
);

insert into authors (name, country) values ('Александр Пушкин', 'РФ');
insert into authors (name, country) values ('Николай Гоголь', 'РФ');
insert into authors (name, country) values ('Эрих Мария Ремарк', 'Германия');
insert into authors (name, country) values ('Маргарет Митчелл', 'США');

create table books (
    id serial primary key,
    "name" varchar(200),
    author_id integer references authors(id)
);

insert into books (name, author_id) values ('Евгений Онегин', 1);
insert into books (name, author_id) values ('Капитанская дочка', 1);
insert into books (name, author_id) values ('Дубровский', 1);
insert into books (name, author_id) values ('Мертвые души', 2);
insert into books (name, author_id) values ('Вий', 2);
insert into books (name, author_id) values ('Жизнь взаймы', 3);
insert into books (name, author_id) values ('Три товарища', 3);
insert into books (name, author_id) values ('Унесённые ветром', 4);

create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);

insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (2, 2);
insert into orders (book_id, student_id) values (6, 2);
insert into orders (book_id, student_id) values (8, 2);

select *
from    students s, orders o, books b, authors a
where   s.id = o.student_id
        and o.book_id = b.id
        and  b.author_id = a.id

--студенты взявшие книги зарубежных авторов и названия этих книг с принадлежностью к стране.
create view show_students_with_foreign_books as
    select  s.name student, a.name  author, a.country
    from    authors a, books b, orders o, students s
    where   a.country not like 'РФ'
            and a.id = b.author_id
            and o.book_id = b.id
            and s.id = o.student_id

select * from show_students_with_foreign_books;