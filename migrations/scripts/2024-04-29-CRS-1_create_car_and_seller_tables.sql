--liquibase formatted sql
--changeset jizapika:1
create table cars (
    id serial primary key,
    color string,
    price int
);

create table sellers (
    id bigserial primary key,
    username string,
    password string,
    active bool
);