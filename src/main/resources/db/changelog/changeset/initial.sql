CREATE TABLE family_member
(
    id BIGINT PRIMARY KEY NOT NULL,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64)
    );

CREATE TABLE transaction_type
(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(64) NOT NULL
    );

CREATE TABLE transaction_category
(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(64) NOT NULL
    );


