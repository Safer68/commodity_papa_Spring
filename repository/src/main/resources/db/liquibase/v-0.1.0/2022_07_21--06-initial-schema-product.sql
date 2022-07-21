create table product
(
    id          bigint auto_increment
        primary key,
    active      bit           null,
    description varchar(2000) null,
    image       varchar(40)   null,
    name        varchar(255)   null,
    price       double        null,
    section     varchar(255)  null
);