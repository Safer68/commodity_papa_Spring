alter table orders
    change date date_of_creation datetime(6) null;

alter table orders
    add date_of_change datetime(6) null;

alter table orders
    add status boolean default true not null;