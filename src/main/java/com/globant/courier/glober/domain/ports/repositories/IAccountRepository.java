package com.globant.courier.glober.domain.ports.repositories;

import com.globant.courier.glober.infrastructure.entities.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAccountRepository {
    Account save(Account account);

    List<Account> findAll();

    public Optional<Account> findById(UUID id);

}
