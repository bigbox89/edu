CREATE SCHEMA IF NOT EXISTS contacts_schema;
create table  IF NOT EXISTS contacts_schema.contacts
(
    id          BIGINT
        constraint contacts_pk
            primary key,
    "firstName" varchar(255) not null,
    "lastName"  varchar(255) not null,
    email       varchar(255) not null,
    phone       varchar(255) not null
);


