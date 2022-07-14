package com.globant.courier.glober.domain.usecases;

import com.globant.courier.glober.domain.models.AccountDto;

import com.globant.courier.glober.domain.ports.repositories.IAccountRepository;
import com.globant.courier.glober.domain.ports.services.IAccountService;
import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.rest.input.AccountInput;
import com.globant.courier.glober.infrastructure.util.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService implements IAccountService {
    private final IAccountRepository iAccountRepository;

    public AccountService(IAccountRepository accountRepository){
        this.iAccountRepository = accountRepository;
    }
/*
    @Override
    public List<AccountDto> findAllWithType(String nemonic) {
        return iAccountRepository.findAllWithType(nemonic);
    }*/

    @Override
    public List<AccountDto> findAll() {
        return ObjectMapperUtils.mapAll(this.iAccountRepository.findAll(), AccountDto.class);
    }



    @Transactional
    public AccountDto save(AccountInput accountInput) {
        Account account = Account.builder()
                .uuidAccount(UUID.randomUUID())
                .idAccount(accountInput.getIdAccount())
                .type(accountInput.getType())
                .balance(accountInput.getBalance())
                .status(accountInput.getStatus())
                //.userAccount(accountInput.getUserAccount())
                //.creationUser(accountInput.getCreationUser())
                //.creationDate(new Date())
                .build();

        //account = iAccountRepository.save(account);
        //return loadClientLocationData(account);
        return ObjectMapperUtils.map(iAccountRepository.save(account), AccountDto.class);
    }
/*
    private AccountDto loadClientLocationData(Account account) {
        String cityLink = "/cities/" + account.getCityId();
        return ClientLocationDto.builder()
                .clientId(account.getClientId())
                .name(account.getName())
                .lastName(account.getLastName())
                .surname(account.getSurname())
                .email(account.getEmail())
                .phoneNumber(account.getPhoneNumber())
                .mainStreet(account.getMainStreet())
                .secondaryStreet(account.getSecondaryStreet())
                .addressNumber(account.getAddressNumber())
                .reference(account.getReference())
                .userAccount(account.getUserAccount())
                .labelAddressMap(account.getLabelAddressMap())
                .urlAddressMap(account.getUrlAddressMap())
                .links(ClientLocationLinks.builder().city(cityLink).build())
                .build();
    }*/
}
