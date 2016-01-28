package com.stenhouse.cassandra.bitcoin.repositories;

import com.stenhouse.cassandra.bitcoin.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Created by jason on 1/28/16.
 */
public interface UserRepository extends CassandraRepository<User> {
}
