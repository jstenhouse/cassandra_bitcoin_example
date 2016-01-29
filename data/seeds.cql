
USE bitcoin;

// users
INSERT INTO users (id, first_name, last_name, email, updated_at) VALUES (0cd7ead0-c5a9-11e5-afeb-abdeecb176e1, 'Bobby', 'Goodtimes', 'bobby@example.com', toTimestamp(now()));

INSERT INTO users (id, first_name, last_name, email, updated_at) VALUES (29842860-c5a9-11e5-afeb-abdeecb176e1, 'Johnny', 'Badtimes', 'johnny@example.com', toTimestamp(now()));


// user wallets
INSERT INTO user_wallets (id, user_id, name, updated_at) VALUES (61728140-c5b3-11e5-9912-ba0be0483c18, 0cd7ead0-c5a9-11e5-afeb-abdeecb176e1, 'Wallet', toTimestamp(now()));
INSERT INTO user_wallets (id, user_id, name, updated_at) VALUES (617283ac-c5b3-11e5-9912-ba0be0483c18, 0cd7ead0-c5a9-11e5-afeb-abdeecb176e1, 'Vault', toTimestamp(now()));

INSERT INTO user_wallets (id, user_id, name, updated_at) VALUES (617284b0-c5b3-11e5-9912-ba0be0483c18, 29842860-c5a9-11e5-afeb-abdeecb176e1, 'Wallet', toTimestamp(now()));
INSERT INTO user_wallets (id, user_id, name, updated_at) VALUES (61728596-c5b3-11e5-9912-ba0be0483c18, 29842860-c5a9-11e5-afeb-abdeecb176e1, 'Vault', toTimestamp(now()));


// wallet_addresses
INSERT INTO wallet_addresses (id, wallet_id, address, updated_at) VALUES (cd194de4-c67f-11e5-9912-ba0be0483c18, 61728140-c5b3-11e5-9912-ba0be0483c18, '12yLN9pVadBjBJQm7JogjsLq8VC5SfnxPM', toTimestamp(now()));
INSERT INTO wallet_addresses (id, wallet_id, address, updated_at) VALUES (cd195064-c67f-11e5-9912-ba0be0483c18, 617283ac-c5b3-11e5-9912-ba0be0483c18, '1Cqpk5jzFecTWoCF9nf8EvFvEyqBE12cm6', toTimestamp(now()));

INSERT INTO wallet_addresses (id, wallet_id, address, updated_at) VALUES (cd19515e-c67f-11e5-9912-ba0be0483c18, 617284b0-c5b3-11e5-9912-ba0be0483c18, '1NEnJHy3tSEVDueUK9L5RkYu8FAvsG1fLx', toTimestamp(now()));
INSERT INTO wallet_addresses (id, wallet_id, address, updated_at) VALUES (cd19542e-c67f-11e5-9912-ba0be0483c18, 61728596-c5b3-11e5-9912-ba0be0483c18, '1FCmCs7mKW5Y8iqtgEeRHWLamWHBJ8cy4o', toTimestamp(now()));
