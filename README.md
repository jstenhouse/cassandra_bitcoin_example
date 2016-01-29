## Cassandra Bitcoin Example

[Spring-Data-Cassandra](http://projects.spring.io/spring-data-cassandra/) only supports Cassandra version 2.x. Be sure you're running that.

## Use

**Note:** Cassandra needs to be running first with the right schema.

```
CASSANDRA_KEYSPACE=bitcoin ./gradlew run
```

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

TODO


### WalletAddresses

TODO

### Cassandra Data

```
cqlsh -f data/schema.cql

cqlsh -f data/seeds.cql
```
