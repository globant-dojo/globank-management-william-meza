package com.globant.courier.glober.infrastructure.repositories.jpa;

import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JournalJpa extends JpaRepository<Journal, UUID> {
}