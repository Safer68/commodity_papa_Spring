create table product
(
    id          int auto_increment
        primary key,
    description varchar(2000) null,
    price       double        null,
    section     varchar(255)  null
);