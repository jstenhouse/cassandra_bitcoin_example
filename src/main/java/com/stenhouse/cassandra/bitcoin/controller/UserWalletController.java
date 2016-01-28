package com.stenhouse.cassandra.bitcoin.controller;

import com.stenhouse.cassandra.bitcoin.model.UserWallet;
import com.stenhouse.cassandra.bitcoin.repositories.UserWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserWallet getUserWallet(@PathVariable("user_id") UUID userId, @PathVariable("id") UUID id) {
        return userWalletRepository.findOne(userId, id);
    }

}
