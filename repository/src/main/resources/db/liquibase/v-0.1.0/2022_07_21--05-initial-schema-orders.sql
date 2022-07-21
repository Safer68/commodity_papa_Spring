create table orders
(
    id               bigint auto_increment
        primary key,
    appt             int          null,
    building         varchar(255) null,
    city             varchar(255) null,
    house            int          null,
    postal_code      int          null,
    street           varchar(255) null,
    date_of_change   datetime(6)  null,
    date_of_creation datetime(6)  null,
    price            double       null,
    status_order     varchar(255) null,
    track_number     varchar(255) null,
    client_id        bigint       null,
    delivery_id      bigint       null,
    manager_id       bigint       null,
    constraint fk_client_order
        foreign key (client_id) references client (id),
    constraint fk_manager_order
        foreign key (manager_id) references manager (id),
    constraint fk_delivery_order
        foreign key (delivery_id) references delivery (id)
);