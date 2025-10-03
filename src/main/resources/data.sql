-- Users
INSERT INTO users (username, password, role)
VALUES ('admin', 'admin123', 'ADMIN');
INSERT INTO users (username, password, role)
VALUES ('John Doe', 'John123', 'USER');
INSERT INTO users (username, password, role)
VALUES ('Alice Smith', 'Alice123', 'USER');
INSERT INTO users (username, password, role)
VALUES ('Bob Johnson', 'Bob123', 'USER');
INSERT INTO users (username, password, role)
VALUES ('Asha', 'Asha123', 'USER');
INSERT INTO users (username, password, role)
VALUES ('Pavana', 'Pavana123', 'USER');
INSERT INTO users (username, password, role)
VALUES ('Hruthika', 'Hruthika123', 'USER');


-- Customers
INSERT INTO customers (name, email, phone)
VALUES ('John Doe', 'john@example.com', '1234567890');
INSERT INTO customers (name, email, phone)
VALUES ('Alice Smith', 'alice@example.com', '9876543210');
INSERT INTO customers (name, email, phone)
VALUES ('Bob Johnson', 'bob@example.com', '5556667777');

-- Accounts
INSERT INTO accounts (customer_id, account_type, balance)
VALUES (1, 'SAVINGS', 5000);
INSERT INTO accounts (customer_id, account_type, balance)
VALUES (2, 'CURRENT', 3000);
INSERT INTO accounts (customer_id, account_type, balance)
VALUES (3, 'SAVINGS', 7000);
INSERT INTO accounts (customer_id, account_type, balance)
VALUES (1, 'CURRENT', 2000);

-- Transactions
INSERT INTO transactions (account_id, type, amount, date)
VALUES (1, 'DEPOSIT', 5000, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (2, 'DEPOSIT', 3000, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (3, 'DEPOSIT', 7000, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (1, 'WITHDRAW', 1000, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (2, 'WITHDRAW', 500, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (4, 'DEPOSIT', 2000, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (3, 'WITHDRAW', 2000, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (1, 'DEPOSIT', 1500, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (2, 'DEPOSIT', 1200, CURRENT_TIMESTAMP());
INSERT INTO transactions (account_id, type, amount, date)
VALUES (3, 'DEPOSIT', 800, CURRENT_TIMESTAMP());
