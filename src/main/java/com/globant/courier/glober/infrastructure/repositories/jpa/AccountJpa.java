package com.globant.courier.glober.infrastructure.repositories.jpa;

import com.globant.courier.glober.infrastructure.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountJpa extends JpaRepository<Account, UUID> {
}