package com.globant.courier.glober.domain.ports.repositories;

import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.entities.Journal;

import java.util.List;

public interface IJournalRepository {
    Journal save(Journal journal);

    //List<Journal> findByDateAndCustomer();

}
