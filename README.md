CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    phone VARCHAR(20)
);

CREATE TABLE accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_type VARCHAR(50),
    balance DOUBLE,
    customer_id BIGINT,
    CONSTRAINT fk_account_customer FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE,
    date TIMESTAMP,
    type VARCHAR(50),
    account_id BIGINT,
    CONSTRAINT fk_transaction_account FOREIGN KEY (account_id) REFERENCES accounts(id)
);
