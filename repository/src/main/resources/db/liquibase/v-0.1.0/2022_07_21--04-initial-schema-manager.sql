create table manager
(
    id         bigint auto_increment
        primary key,
    name       varchar(255) null,
    user_id    bigint       null,
    patronymic varchar(255) null,
    surname    varchar(255) null,
    constraint fk_user_manager
        foreign key (user_id) references user (id)
);