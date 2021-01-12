create schema pizzadb;

create table if not exists products
(id bigint not null, name varchar(255), description varchar(255), price decimal(19,2), primary key (id));

insert into products
values (1,'Meal1','Lorem ipsum meal1',1.11);
insert into products
values (2,'Meal2','Lorem ipsum meal2',2.22);
insert into products
values (3,'Meal3','Lorem ipsum meal3',3.22);