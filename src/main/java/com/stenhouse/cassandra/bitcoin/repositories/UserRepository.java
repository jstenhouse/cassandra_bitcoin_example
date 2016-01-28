package com.stenhouse.cassandra.bitcoin.repositories;

import com.stenhouse.cassandra.bitcoin.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.UUID;

/**
 * Created by jason on 1/28/16.
 */
public interface UserRepository extends CassandraRepository<User> {

    // named params don't seem to be supported yet...
    @Query("INSERT INTO users (id, first_name, last_name, email, updated_at) VALUES (now(), ?0, ?1, ?2, toTimestamp(now()))")
    void create(String firstName, String lastName, String email);

    @Query("UPDATE users SET first_name = ?1, last_name = ?2, email = ?3, updated_at = toTimestamp(now()) WHERE id = ?0")
    User update(UUID id, String firstName, String lastName, String email);
}
