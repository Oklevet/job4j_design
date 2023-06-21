CREATE TABLE accounts(
    id int not null primary key,
    name text,
    login text,
    password text
);

INSERT INTO accounts VALUES(1, 'Petr Arsentev', 'parsentev', '1234');
INSERT INTO accounts VALUES(2, 'Andrey Hincu', 'anincu', '4321');
INSERT INTO accounts VALUES(3, 'Lana Sergeeva', 'lserg', '2156');
INSERT INTO accounts VALUES(4, 'Petr Arsentev', 'arsentev_p', '1234');
INSERT INTO accounts VALUES(5, 'Andrey Hincu', 'nincu_a', '4321');
INSERT INTO accounts VALUES(6, 'Lana Sergeeva', 'serg_l', '2156');

select distinct (name), login, password from accounts;