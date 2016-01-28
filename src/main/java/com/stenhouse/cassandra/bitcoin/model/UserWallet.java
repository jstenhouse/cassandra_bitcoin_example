package com.stenhouse.cassandra.bitcoin.model;

import com.google.common.base.MoreObjects;
import com.stenhouse.cassandra.bitcoin.controller.UserWalletController;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by jason on 1/27/16.
 */
@Table
public class UserWallet {

    @PrimaryKey
    private UserWalletId id;

    public UserWallet(final UserWalletId id) {
        this.id = id;
    }

    public UserWalletId getId() {
        return id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .toString();
    }



    @PrimaryKeyClass
    public static class UserWalletId implements Serializable {

        @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        private UUID userId;

        @PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
        private UUID id;

        public UUID getUserId() {
            return userId;
        }

        public void setUserId(final UUID userId) {
            this.userId = userId;
        }

        public UUID getId() {
            return id;
        }

        public void setId(final UUID id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, id);
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }

            if (getClass() != other.getClass()) {
                return false;
            }

            final UserWalletId otherId = (UserWalletId) other;

            return Objects.equals(this.userId, otherId.getUserId())
                    && Objects.equals(this.id, otherId.getId());
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("userId", userId)
                    .add("id", id)
                    .toString();
        }
    }

}
