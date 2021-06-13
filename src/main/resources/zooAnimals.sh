#!/bin/bash

psql -d zoo -U zoo_user -c "\
create table zoo \
( \
id int not null, \
type varchar(50) not null, \
name varchar(50) not null unique, \
amount int not null, \
constraint PK_Zoo primary key(id) \
); \
  \
insert into zoo \
values \
(0, 'carnivore', 'Lion', 4), \
(1, 'carnivore', 'Bear', 2), \
(2, 'herbivore', 'Zebra', 3), \
(3, 'herbivore', 'Elephant', 2);"

