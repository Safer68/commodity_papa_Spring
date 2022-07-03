create table orders
(
    id          int auto_increment
        primary key,
    date        datetime(6) null,
    client_id   int         null,
    delivery_id int         null,
    manager_id  int         null,
    constraint client_fk
        foreign key (client_id) references client (id),
    constraint manager_fk
        foreign key (manager_id) references manager (id),
    constraint delivery_fk
        foreign key (delivery_id) references delivery (id)
);