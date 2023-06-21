CREATE TABLE subjects(
    id int not null primary key,
    name text,
    grade int,
    start_date timestamp
);

INSERT INTO subjects VALUES(1, 'Math', 75, current_date);
INSERT INTO subjects VALUES(2, 'English', 85, current_date);
INSERT INTO subjects VALUES(3, 'Math', 50, current_date);
INSERT INTO subjects VALUES(4, 'Computer Science', 95, current_date);
INSERT INTO subjects VALUES(5, 'English', 75, current_date);
INSERT INTO subjects VALUES(6, 'Computer Science', 85, current_date);

select * from subjects order by name, grade;