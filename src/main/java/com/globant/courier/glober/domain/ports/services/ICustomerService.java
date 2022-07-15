package com.globant.courier.glober.domain.ports.services;

import com.globant.courier.glober.domain.models.AccountDto;
import com.globant.courier.glober.domain.models.CustomerDto;
import com.globant.courier.glober.infrastructure.rest.input.AccountInput;
import com.globant.courier.glober.infrastructure.rest.input.CustomerInput;

import java.util.List;

public interface ICustomerService {

	CustomerDto save(CustomerInput customerInput);
	List<CustomerDto> findAll();

}
