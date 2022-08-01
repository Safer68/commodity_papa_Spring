insert into user(active, password, user_name)
VALUES (true,
        '$2y$12$kjBEvSNH8oN9508Vi8gpLOxzxsfc7H/HLRTQatlR4z3JOzrC4YXB6',
        'admin');
insert into user(active, password, user_name)
VALUES (true,
        '$2y$12$kjBEvSNH8oN9508Vi8gpLOxzxsfc7H/HLRTQatlR4z3JOzrC4YXB6',
        'manager');
insert into user(active, password, user_name)
VALUES (true,
        '$2y$12$kjBEvSNH8oN9508Vi8gpLOxzxsfc7H/HLRTQatlR4z3JOzrC4YXB6',
        'client');


insert into roles(name)
VALUES ('ADMIN');
insert into roles(name)
VALUES ('MANAGER');
insert into roles(name)
VALUES ('CLIENT');

insert into user_role(user_id, role_id)
VALUES (1, 1);
insert into user_role(user_id, role_id)
VALUES (11, 11);
insert into user_role(user_id, role_id)
VALUES (21, 21);

insert into manager(name, user_id, patronymic, surname)
VALUES ('Василий', 11, 'Иванович', 'Петров');

insert into client(name, patronymic, surname, phone_number, city, street, house, building, appt, postal_code, email,
                   user_id)
VALUES ('Леонид', 'Васильевич', 'Мороз', '+375257056517', 'Минск', 'Ленина', 80, 1, 45, 222310, 'lev@mail.ru', 21);

insert into product(active, name, description, price, section,image)
VALUES (true, 'Ракетка Sponeta HighTech',
        'Игровые показатели:
контроль - 60%
скорость - 85%
вращение - 70%
Резиновое покрытие - Shogun
Лезвие - нападение
Ручка - вогнутая
Размеры в упакованном виде: 26 х 15 х 1,5 см. Вес до 1 кг.', 146.0, 'S','5821d16bfbb54076b974a97c6c88d894.jpg');
insert into product(active, name, description, price, section,image)
VALUES (true, 'Гитара акустическая Cort AD810 OP',
        'Особенности:
акустическая гитара с корпусом формы дредноут;
верхняя дека из ели;
нижняя дека и обечайки из махагони;
гриф из махагони;
накладка на гриф из мербау, 20 ладов, инкрустация точками;
крепление грифа вида "ласточкин хвост";
литые колки;
бридж из мербау особой формы;
ширина грифа у верхнего порожка: 43 мм;
длина мензуры: 643 мм;
отделка корпуса: Open Pore;
цвет: натуральный.', 432.00, 'M','31a16cb3427d479d831855857eaa6633.jpg');
insert into product(active, name, description, price, section,image)
VALUES (true, 'Внешний аккумулятор Xiaomi Redmi Power Bank 10000 мАч',
        'Xiaomi Redmi Power Bank 10 000 мАч выделяется не только утонченным дизайном,
но и своей компактностью. Грациозные линии корпуса привлекают внимание в любой обстановке,
а премиальные материалы отвечают за надежность и практичность.
Пауэрбанк от Xiaomi — незаменимый аксессуар для любого гаджета.', 49.5, 'T','85296e0a9d5542b9a0859419efc31835.png');

insert into delivery(name)
VALUES ('Belpost');
insert into delivery(name)
VALUES ('Курьер');

insert into orders(date_of_change, date_of_creation, price,
                   status_order, track_number, client_id, delivery_id, city, street, house, building, appt, postal_code,
                   manager_id)
VALUES ('2022-06-05 00:00:00', '2022-06-10 00:00:00', 627.5, 'Получен', 'PC051558650BY', 1, 1, 'Минск',
        'Ленина', 80, 1, 45, 222310, 1);

