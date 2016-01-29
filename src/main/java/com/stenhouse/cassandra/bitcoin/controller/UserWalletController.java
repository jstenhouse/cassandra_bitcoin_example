package com.stenhouse.cassandra.bitcoin.controller;

import com.stenhouse.cassandra.bitcoin.model.UserWallet;
import com.stenhouse.cassandra.bitcoin.repositories.UserWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by jason on 1/27/16.
 */
@RestController
@RequestMapping(value="/users/{user_id}/wallets")
public class UserWalletController {

    @Autowired
    private UserWalletRepository userWalletRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserWallet> getUserWallets(@PathVariable("user_id") UUID userId) {
        return userWalletRepository.findAllByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserWallet createUserWallet(@PathVariable("user_id") UUID userId, @RequestBody UserWallet userWallet) {
        return userWalletRepository.create(userId, userWallet.getName());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserWallet getUserWallet(@PathVariable("user_id") UUID userId, @PathVariable("id") UUID id) {
        return userWalletRepository.findOne(userId, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserWallet updateUserWallet(@PathVariable("user_id") UUID userId, @PathVariable("id") UUID id, @RequestBody UserWallet userWallet) {
        return userWalletRepository.update(userId, id, userWallet.getName());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserWallet(@PathVariable("id") UUID id) {
        throw new UnsupportedOperationException();
    }

}
