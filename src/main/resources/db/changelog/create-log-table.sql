create table log
(
    id       bigint auto_increment primary key,
    created_date    timestamp,
    payload     varchar(255)
);
