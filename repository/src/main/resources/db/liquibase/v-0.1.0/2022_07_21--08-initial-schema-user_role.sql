create table user_role
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    constraint fk_user_role
        foreign key (user_id) references user (id),
    constraint fk_role_user
        foreign key (role_id) references roles (id)
);