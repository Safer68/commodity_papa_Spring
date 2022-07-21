create table client
(
    id           bigint auto_increment
        primary key,
    appt         int          null,
    building     varchar(255) null,
    city         varchar(255) null,
    house        int          null,
    postal_code  int          null,
    street       varchar(255) null,
    email        varchar(255) null,
    name         varchar(255) null,
    patronymic   varchar(255) null,
    phone_number varchar(255) null,
    surname      varchar(255) null,
    user_id      bigint       null,
    constraint fk_user_client
        foreign key (user_id) references user (id)
);