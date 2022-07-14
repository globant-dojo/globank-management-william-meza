package com.globant.courier.glober.infrastructure.repositories;

import com.globant.courier.glober.domain.ports.repositories.IJournalRepository;
import com.globant.courier.glober.infrastructure.entities.Journal;
import com.globant.courier.glober.infrastructure.repositories.jpa.JournalJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JournalRepository implements IJournalRepository {
    @Autowired
    JournalJpa journalJpa;

    public Journal save(Journal account){
        return journalJpa.save(account);
    }



//    public List<Journal> findAll(){
//        return journalJpa.findAll();
//    }
}