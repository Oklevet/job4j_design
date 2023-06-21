CREATE TABLE subjects(
    id int not null primary key,
    name text,
    grade int,
    start_date timestamp
);

INSERT INTO subjects VALUES(1, 'Math', 75, current_date);
INSERT INTO subjects VALUES(2, 'Math', null, current_date);
INSERT INTO subjects VALUES(3, 'Math', 75, current_date);
INSERT INTO subjects VALUES(4, 'Math', 85, current_date);
INSERT INTO subjects VALUES(5, 'Math', null, current_date);

select distinct name, grade from subjects;