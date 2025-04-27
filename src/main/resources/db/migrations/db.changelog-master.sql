--liquibase formatted sql

--changeset todo_list_bff:0001_ddl_create_table_todo_task
create table todo_task (
		"id" bigserial not null, -- Must be "bigserial" so postgres handles the ID assignment by itself
		"title" varchar(30) not null,
		"description" varchar(255) null,
		constraint pk_todo_task primary key (id)
);
--rollback drop table todo_task;