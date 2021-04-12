create table catalog(
    id serial primary key,
    names varchar(100),
    type varchar(100),
    quantity numeric     
);

insert into catalog (names, type, quantity) values ('NVIDIA GeForce 1080', 'Graphic Card', 10);
insert into catalog (names, type, quantity) values ('NVIDIA GeForce 1080Ti', 'Graphic Card', 12);
insert into catalog (names, type, quantity) values ('NVIDIA GeForce 2070', 'Graphic Card', 17);
insert into catalog (names, type, quantity) values ('NVIDIA GeForce RTX 3070', 'Graphic Card', 1);
insert into catalog (names, type, quantity) values ('INTEL Core i7 10700', 'CPU', 4);
insert into catalog (names, type, quantity) values ('INTEL Core i9 10900', 'CPU', 2);
insert into catalog (names, type, quantity) values ('KINGSTON HyperX FURY', 'RAM', 27);
insert into catalog (names, type, quantity) values ('Crucial Ballistix Red', 'RAM', 50);
insert into catalog (names, type, quantity) values ('CORSAIR Vengeance RGB Pro', 'RAM', 30);

update catalog set quantity = 0;
delete from catalog;

select * from catalog;