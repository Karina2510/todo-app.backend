/*CRIAR TABELAS*/

USE project_tasks;

CREATE TABLE tasks(
	id VARCHAR (36) primary key,
    name VARCHAR (200) NOT NULL,
    due_time TIME,
    created_at DATETIME NOT NULL,
    update_at DATETIME NOT NULL
);

CREATE TABLE routines(
	id VARCHAR (36) primary key,
    tasks_id VARCHAR (36) NOT NULL,
    due_date DATETIME NOT NULL,
    is_finished BOOLEAN NOT NULL,
    FOREIGN KEY (tasks_id) REFERENCES TASKS(id)
);

INSERT INTO tasks(id, name, due_time, created_at, update_at) values ('BBBBB', 'curso JPA', '18:30', '2023-10-25 18:30:20', '2023-10-25 19:40:25');
INSERT INTO routines(id, due_date, due_time, is_finished, tasks_id) values ('BBBBB', 'curso JPA', '18:30', '2023-10-25 18:30:20', '2023-10-25 19:40:25');



 -- drop table routines;
 -- drop table tasks;

select * from tasks;