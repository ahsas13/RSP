-- раскомментируйте следующую строку, если требуется пересоздать таблицу
-- drop table employee;
-- создание таблицы
create table employee(id integer,
                      first_name varchar(20),
                      last_name varchar(20),
                      designation varchar(20),
                      phone varchar(20));
--вставка тестовых данных
insert into employee values (1, 'John', 'Doe', 'Manager', '+7 (900) 001-0101');
insert into employee values (2, 'James', 'Bond', 'Programmer', '+7 (900) 002-0202');
insert into employee values (3, 'Philip', 'Morris', 'Driver', '+7 (900) 003-0303');
insert into employee values (4, 'Nikol', 'Kidman', 'Director', '+7 (900) 004-0404');
insert into employee values (5, 'Peter', 'Gabriel', 'Technician', '+7 (900) 005-0505');
-- выбрать все записи из таблицы для проверки
select * from employee;