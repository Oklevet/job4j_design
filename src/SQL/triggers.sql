create table products (
    id serial primary key,
    "name" varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create trigger discount_trigger
    after insert
    on products
    for each row
    execute procedure discount();

create or replace function discount
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5 AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);

alter table имя_таблицы disable trigger имя_триггера;
alter table products disable trigger discount_trigger;

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
drop trigger discount_trigger on products;

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted) and count <= 5;
        return new;
    END;
$$
LANGUAGE 'plpgsql';


--new triggers
create or replace function add_tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.1
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure add_tax();

create or replace function add_tax2()
    returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.1;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_tax_trigger_2
    before insert
    on products
    for each row
    execute procedure add_tax2();


create table history_of_price (
    id serial primary key,
    "name" varchar(50),
    price integer,
    "date" timestamp
);

create or replace function add_tax2()
    returns trigger as
$$
    BEGIN
        insert into history_of_price("name", price, "date") VALUES (new.name, new.price, now());
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger add_history_price_trigger
    before insert
    on products
    for each row
    execute procedure add_tax2();