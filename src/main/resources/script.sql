create database todo;

CREATE TABLE tbl_user (
		ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
		USER_NAME VARCHAR(100) NOT NULL,
		PASSWORD VARCHAR(100) NOT NULL,
		FULL_NAME VARCHAR(60),
		STATUS TINYINT(6) DEFAULT 0
	);

INSERT INTO tbl_user(user_name, password, full_name, status) values ('admin', 'demo', 'Admin User', 1);

create table tbl_tasklog(
        tasklog_id integer not null auto_increment primary key,
        current_dttm datetime,
        stat_comment varchar(200),
        task_id integer
    );

create table tbl_status(
        status_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
        status_value VARCHAR(100)
    );

insert into tbl_status values (1, 'Open');
insert into tbl_status values (2, 'InProgress');
insert into tbl_status values (3, 'OnHold');
insert into tbl_status values (4, 'Completed');

create table tbl_todolist(
        task_id integer not null auto_increment primary key,
        user_id integer not null,
        task varchar(100),
        exp_startdttm datetime,
        exp_enddttm datetime,
        actual_startdttm datetime,
        actual_enddttm datetime,
        status integer,
        stat_comment varchar(400),
        complete_perc integer,
        priority integer,
        is_deviated integer,
        deviation_dttm datetime,
        deviation_reason varchar(200)
    );