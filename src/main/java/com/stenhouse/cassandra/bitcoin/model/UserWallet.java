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
 * Created by jason on 1/27/16.
 */
@Table("user_wallets")
public class UserWallet {

    @PrimaryKey
    @JsonUnwrapped
    private UserWalletId id;

    @Column
    private String name;

    @Column("updated_at")
    private Date updatedAt;

    public UserWallet() {}

    public UserWallet(final UserWalletId id, final String name, final Date updatedAt) {
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
    }

    public UserWalletId getId() {
        return id;
    }

    public void setId(final UserWalletId id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
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
                .add("name", name)
                .add("updatedAt", updatedAt)
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
