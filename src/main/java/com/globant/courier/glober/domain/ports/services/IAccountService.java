package com.globant.courier.glober.domain.ports.services;

import com.globant.courier.glober.domain.models.AccountDto;
import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.rest.input.AccountInput;

import java.util.List;

public interface IAccountService {

	//List<AccountDto> findAllWithType(String nemonic);

	AccountDto save(AccountInput accountInput);
	List<AccountDto> findAll();

}
