create table user
(
    id        bigint auto_increment
        primary key,
    active    bit          null,
    password  varchar(255) null,
    user_name varchar(255) null
);