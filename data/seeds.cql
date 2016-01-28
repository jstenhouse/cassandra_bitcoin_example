
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
// TODO
