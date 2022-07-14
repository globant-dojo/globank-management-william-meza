package com.globant.courier.glober.domain.ports.repositories;

import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.entities.Customer;

import java.util.List;

public interface ICustomerRepository {
    Customer save(Customer customer);

    List<Customer> findAll();

}
