/*CRIAR TABELAS*/

use project_tasks;

CREATE TABLE tasks(
	id VARCHAR (36) primary key,
    name VARCHAR (200) NOT NULL,
    due_time TIME,
    is_archived boolean,
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

INSERT INTO tasks(id, name, due_time, is_archived, created_at, update_at) values ('AAAA','curso JPA', '18:30', false, '2023-10-25 18:30:20', '2023-10-25 19:40:25');
INSERT INTO routines(id, tasks_id, due_date, is_finished) values ('BBBBB', 'AAAA','2023-10-25 18:30:20', false);



 -- drop table routines;
 -- drop table tasks;

select * from tasks;