
package com.bernardomg.example.ws.security.basic.user.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardomg.example.ws.security.basic.user.model.User;
import com.bernardomg.example.ws.security.basic.user.repository.PersistentUserRepository;

@Service
public final class DefaultUserService implements UserService {

    private final PersistentUserRepository repository;

    @Autowired
    public DefaultUserService(final PersistentUserRepository repo) {
        super();

        repository = Objects.requireNonNull(repo);
    }

    @Override
    public final Iterable<? extends User> getUsers() {
        return repository.findAll();
    }

}
