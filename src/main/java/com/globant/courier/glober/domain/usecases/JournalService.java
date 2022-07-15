package com.globant.courier.glober.domain.usecases;

import com.globant.courier.glober.domain.models.JournalDto;
import com.globant.courier.glober.domain.ports.repositories.IAccountRepository;
import com.globant.courier.glober.domain.ports.repositories.IJournalRepository;
import com.globant.courier.glober.domain.ports.services.IJournalService;
import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.entities.Journal;
import com.globant.courier.glober.infrastructure.rest.input.JournalInput;
import com.globant.courier.glober.infrastructure.util.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class JournalService implements IJournalService {
    private final IJournalRepository iJournalRepository;
    private final IAccountRepository iAccountRepository;

    public JournalService(IJournalRepository journalRepository, IAccountRepository accountRepository){
        this.iJournalRepository = journalRepository;
        this.iAccountRepository = accountRepository;
    }

    @Transactional
    public JournalDto save(JournalInput journalInput) {
        Account account = new Account();
        Float newBalance = null;
        Optional<Account> accountOptional = iAccountRepository.findById(UUID.fromString(journalInput.getUuidAccount()));
        if(!accountOptional.isEmpty()) {
            account = accountOptional.get();
        }

        newBalance = account.getBalance()-journalInput.getAmount();
        if(newBalance >= 0) {
            Journal journal = Journal.builder()
                    .uuidJournal(UUID.randomUUID())
                    .account(account)//fk
                    .creationDate(new Date())
                    .balance(newBalance)
                    .amount(journalInput.getAmount())
                    .type(journalInput.getType())
                    .build();

            //update Account with the new balance
            account.setBalance(journal.getBalance());
            iAccountRepository.save(account);


            return ObjectMapperUtils.map(iJournalRepository.save(journal), JournalDto.class);
        }else{
            return null;
        }

    }

}
