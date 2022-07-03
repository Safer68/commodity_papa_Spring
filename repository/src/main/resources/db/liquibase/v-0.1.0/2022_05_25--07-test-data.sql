insert into client(city, postal_code, street, name, patronymic, phone_number, surname)
VALUES ('Minsk', 220102, 'Varvasheni', 'Vasya', 'Ivanovich', +375257056517, 'Ivanov');

insert into delivery(name)
VALUES ('Belpost');

insert into manager(name)
VALUES ('manager2');

insert into product(description, price, section)
VALUES ('description', 455.1, 'S');

insert into orders(date, client_id, delivery_id, manager_id)
VALUES ('2022-05-04', 1, 1, 1);

insert into order_products(order_id, products_id)
VALUES (1, 1);

insert into orders(date, client_id, delivery_id, manager_id)
VALUES ('2022-05-05', null, null, null);