create table order_products
(
    order_id    int not null,
    products_id int not null,
    primary key (order_id, products_id),
    constraint order_fk
        foreign key (order_id) references orders (id),
    constraint products_fk
        foreign key (products_id) references product (id)
);