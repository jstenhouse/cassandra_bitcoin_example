## Cassandra Bitcoin Example

[Spring-Data-Cassandra](http://projects.spring.io/spring-data-cassandra/) only supports Cassandra version 2.x. Be sure you're running that.

## Use

**Note:** Cassandra needs to be running first.

```
CASSANDRA_KEYSPACE=bitcoin ./gradlew run
```

```
http://localhost:8080/users

http://localhost:8080/users/0cd7ead0-c5a9-11e5-afeb-abdeecb176e1
```

### Cassandra Data

```
cqlsh -f data/schema.cql

cqlsh -f data/seeds.cql
```
