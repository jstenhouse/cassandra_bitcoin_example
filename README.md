## Cassandra Bitcoin Example

[Spring-Data-Cassandra](http://projects.spring.io/spring-data-cassandra/) only supports Cassandra version 2.x. Be sure you're running that.

## Use

**Note:** Cassandra needs to be running first with the right schema.

```
CASSANDRA_KEYSPACE=bitcoin ./gradlew run
```

## TODO

Move to URL scheme that doesn't get super long with UUIDs and nested resources. Something like /v1/users, /v1/wallets, /v1/addresses, etc.

### Users

#### List

```
http://localhost:8080/users

http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1
```

#### Create

```
curl -H "Content-Type: application/json" -X POST -d '{"firstName":"Eddy", "lastName":"Mehtimes", "email":"eddy@example.com"}' http://localhost:8080/users
```

#### Update

```
curl -H "Content-Type: application/json" -X PUT -d '{"firstName":"Eddy", "lastName":"Mehtimes", "email":"eddy2@example.com"}' http://localhost:8080/users/ffda7110-c5b0-11e5-8036-abdeecb176e1
```

#### Delete

```
curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1
```


### UserWallets

#### List

```
http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets

http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/61728140-c5b3-11e5-9912-ba0be0483c18
```

#### Create

```
curl -H "Content-Type: application/json" -X POST -d '{"name":"Backup Wallet"}' http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets
```

#### Update

```
curl -H "Content-Type: application/json" -X PUT -d '{"name":"Backup Wallet2"}' http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/6849cea0-c67c-11e5-8036-abdeecb176e1
```

#### Delete

```
curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/6849cea0-c67c-11e5-8036-abdeecb176e1
```


### WalletAddresses

#### List

```
http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/61728140-c5b3-11e5-9912-ba0be0483c18/addresses

http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/61728140-c5b3-11e5-9912-ba0be0483c18/addresses/cd194de4-c67f-11e5-9912-ba0be0483c18
```

#### Create

```
curl -H "Content-Type: application/json" -X POST -d '{"address":"14yLN9pDadBjBJjm7JogjsLq8VC5SfnxPN"}' http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/61728140-c5b3-11e5-9912-ba0be0483c18/addresses
```

#### Update

```
curl -H "Content-Type: application/json" -X PUT -d '{"address":"14yLN9pDadBjBJjm7JogjsLq8VC5SfKxXN"}' http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/61728140-c5b3-11e5-9912-ba0be0483c18/addresses/cd194de4-c67f-11e5-9912-ba0be0483c18
```

#### Delete

```
curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1/wallets/61728140-c5b3-11e5-9912-ba0be0483c18/addresses/cd194de4-c67f-11e5-9912-ba0be0483c18
```


### Cassandra Data

```
cqlsh -f data/schema.cql

cqlsh -f data/seeds.cql
```
