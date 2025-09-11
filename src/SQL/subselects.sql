CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);


INSERT INTO customers
VALUES (1, 'Иван', 'Иванов', 30, 'РФ'),
       (2, 'Петр', 'Петров', 40, 'РФ'),
       (3, 'Джон', 'Смит', 20, 'США'),
       (4, 'Джейн', 'Доу', 35, 'Англ'),
       (5, 'Катя', 'Фролова', 20, 'РФ');

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO orders VALUES
    (1, 3000, 2),
    (2, 35000, 1),
    (3, 83000, 3),
    (4, 52000, 3),
    (5, 373000, 1),
    (6, 24000, 4),
    (7, 11000, 2);

--запрос 1, который вернет список клиентов, возраст которых является минимальным.
select * from customers c
where c.age = (select min(age) from customers);

--запрос 2, который вернет список пользователей, которые еще не выполнили ни одного заказа
select * from customers c
where id not in (
                    select customer_id from orders
                )