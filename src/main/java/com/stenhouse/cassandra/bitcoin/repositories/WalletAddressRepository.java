package com.stenhouse.cassandra.bitcoin.repositories;

import com.stenhouse.cassandra.bitcoin.model.WalletAddress;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * Created by jason on 1/29/16.
 */
public interface WalletAddressRepository extends CassandraRepository<WalletAddress> {

    @Query("SELECT * FROM wallet_addresses WHERE wallet_id = ?0 AND id = ?1")
    WalletAddress findOne(UUID walletId, UUID id);

    @Query("SELECT * FROM wallet_addresses WHERE wallet_id = ?0")
    List<WalletAddress> findAllByWalletId(UUID walletId);

    @Query("INSERT INTO wallet_addresses (id, wallet_id, address, updated_at) VALUES (now(), ?0, ?1, toTimestamp(now()))")
    WalletAddress create(UUID walletId, String address);

    @Query("UPDATE wallet_addresses SET address = ?2, updated_at = toTimestamp(now()) WHERE wallet_id = ?0 AND id = ?1")
    WalletAddress update(UUID walletId, UUID id, String address);

    @Query("DELETE FROM wallet_addresses WHERE wallet_id = ?0 AND id = ?1")
    void delete(UUID walletId, UUID id);

}
