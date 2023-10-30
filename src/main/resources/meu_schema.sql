/*CRIAR TABELAS*/

USE projeto_tarefas;

CREATE TABLE tasks(
	id VARCHAR (36) primary key,
    name VARCHAR (200) NOT NULL,
    created_at DATE NOT NULL,
    update_at DATE NOT NULL
);

CREATE TABLE routines(
	id VARCHAR (36) primary key,
    due_date DATE NOT NULL,
    is_finished BOOLEAN NOT NULL,
    tasks_id VARCHAR (36) NOT NULL,
    FOREIGN KEY (tasks_id) REFERENCES TASKS(id)
);
