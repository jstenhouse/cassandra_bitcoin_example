package com.stenhouse.cassandra.bitcoin.repositories;

import com.stenhouse.cassandra.bitcoin.model.UserWallet;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * Created by jason on 1/28/16.
 */
public interface UserWalletRepository extends CassandraRepository<UserWallet> {

    // default findOne with a composite primary key isn't supported as far as I can tell
    @Query("SELECT * FROM user_wallets WHERE user_id = ?0 AND id = ?1")
    UserWallet findOne(UUID userId, UUID id);

    // default findAll with a composite primary key isn't supported
    @Query("SELECT * FROM user_wallets WHERE user_id = ?0")
    List<UserWallet> findAllByUserId(UUID userId);

    @Query("INSERT INTO user_wallets (id, user_id, name, updated_at) VALUES (now(), ?0, ?1, toTimestamp(now()))")
    UserWallet create(UUID userId, String name);

    @Query("UPDATE user_wallets SET name = ?2, updated_at = toTimestamp(now()) WHERE user_id = ?0 AND id = ?1")
    UserWallet update(UUID userId, UUID id, String name);

}
