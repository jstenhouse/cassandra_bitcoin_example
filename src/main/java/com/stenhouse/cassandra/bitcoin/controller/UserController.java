package com.stenhouse.cassandra.bitcoin.controller;

import com.google.common.collect.Lists;
import com.stenhouse.cassandra.bitcoin.model.User;
import com.stenhouse.cassandra.bitcoin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.support.BasicMapId;
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
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") UUID id) {
        return userRepository.findOne(BasicMapId.id("id", id));
    }


}
