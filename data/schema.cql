
DROP KEYSPACE IF EXISTS bitcoin;
CREATE KEYSPACE bitcoin WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 };

USE bitcoin;

CREATE TABLE users (
    id timeuuid,
    first_name text,
    last_name text,
    email text,
    updated_at timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE user_wallets (
    id timeuuid,
    user_id timeuuid,
    name text,
    updated_at timestamp,
    PRIMARY KEY ((user_id), id)
);

CREATE TABLE wallet_addresses (
    id timeuuid,
    wallet_id timeuuid,
    address text,
    updated_at timestamp,
    PRIMARY KEY ((wallet_id), id)
);
