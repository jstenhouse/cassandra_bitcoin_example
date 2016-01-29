package com.stenhouse.cassandra.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.google.common.base.MoreObjects;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by jason on 1/29/16.
 */
@Table("wallet_addresses")
public class WalletAddress {

    @PrimaryKey
    @JsonUnwrapped
    private WalletAddressId id;

    @Column
    private String address;

    @Column("updated_at")
    private Date updatedAt;

    public WalletAddress() {}

    public WalletAddress(final WalletAddressId id, final String address, final Date updatedAt) {
        this.id = id;
        this.address = address;
        this.updatedAt = updatedAt;
    }

    public WalletAddressId getId() {
        return id;
    }

    public void setId(final WalletAddressId id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("address", address)
                .add("updatedAt", updatedAt)
                .toString();
    }

    @PrimaryKeyClass
    public static class WalletAddressId implements Serializable {

        @PrimaryKeyColumn(name = "wallet_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        private UUID walletId;

        @PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
        private UUID id;

        public WalletAddressId() {}

        public UUID getWalletId() {
            return walletId;
        }

        public void setWalletId(UUID walletId) {
            this.walletId = walletId;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(walletId, id);
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }

            if (getClass() != other.getClass()) {
                return false;
            }

            final WalletAddressId otherId = (WalletAddressId) other;

            return Objects.equals(this.walletId, otherId.getWalletId())
                    && Objects.equals(this.id, otherId.getId());
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("walletId", walletId)
                    .add("id", id)
                    .toString();
        }
    }
}
