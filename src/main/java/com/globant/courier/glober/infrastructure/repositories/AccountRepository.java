package com.globant.courier.glober.infrastructure.repositories;

import com.globant.courier.glober.domain.ports.repositories.IAccountRepository;
import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.repositories.jpa.AccountJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountRepository implements IAccountRepository {
    @Autowired
    AccountJpa accountJpa;

    public Account save(Account account){
        return accountJpa.save(account);
    }



    public List<Account> findAll(){
        return accountJpa.findAll();
    }

    public Optional<Account> findById(UUID id){
        return accountJpa.findById(id);
    }
}