create table client
(
    id           int auto_increment
        primary key,
    city         varchar(255) null,
    postal_code  int          null,
    street       varchar(255) null,
    name         varchar(20)  null,
    patronymic   varchar(20)  null,
    phone_number varchar(15)  null,
    surname      varchar(20)  null
);