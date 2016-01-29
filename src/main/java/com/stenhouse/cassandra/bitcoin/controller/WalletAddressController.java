package com.stenhouse.cassandra.bitcoin.controller;

import com.stenhouse.cassandra.bitcoin.model.WalletAddress;
import com.stenhouse.cassandra.bitcoin.repositories.WalletAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by jason on 1/27/16.
 */
@RestController
@RequestMapping(value="/users/{user_id}/wallets/{wallet_id}/addresses")
public class WalletAddressController {

    @Autowired
    private WalletAddressRepository walletAddressRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<WalletAddress> getUserWallets(@PathVariable("wallet_id") UUID walletId) {
        return walletAddressRepository.findAllByWalletId(walletId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public WalletAddress createUserWallet(@PathVariable("wallet_id") UUID walletId, @RequestBody WalletAddress walletAddress) {
        return walletAddressRepository.create(walletId, walletAddress.getAddress());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WalletAddress getUserWallet(@PathVariable("wallet_id") UUID walletId, @PathVariable("id") UUID id) {
        return walletAddressRepository.findOne(walletId, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public WalletAddress updateUserWallet(@PathVariable("wallet_id") UUID walletId, @PathVariable("id") UUID id, @RequestBody WalletAddress walletAddress) {
        return walletAddressRepository.update(walletId, id, walletAddress.getAddress());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserWallet(@PathVariable("wallet_id") UUID walletId, @PathVariable("id") UUID id) {
        walletAddressRepository.delete(walletId, id);
    }
}
