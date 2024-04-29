--liquibase formatted sql
--changeset jizapika:1
create table cars (
    id serial primary key,
    color varchar(32),
    price int
);

create table sellers (
    id bigserial primary key,
    username varchar(128),
    password varchar(128),
    active bool
);