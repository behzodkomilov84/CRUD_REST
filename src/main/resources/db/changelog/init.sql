--liquibase formatted sql

--changeset behzod:1
create table humans
(
    id   bigint auto_increment primary key,
    name varchar(255),
    age  int
);

--changeset behzod:2
create table cars
(
    id       bigint auto_increment primary key,
    model    varchar(255),
    year     bigint,
    human_id bigint,
    foreign key (human_id) references humans(id)
);

