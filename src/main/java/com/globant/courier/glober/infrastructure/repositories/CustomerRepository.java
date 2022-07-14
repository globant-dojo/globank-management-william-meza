package com.globant.courier.glober.infrastructure.repositories;

import com.globant.courier.glober.domain.ports.repositories.ICustomerRepository;
import com.globant.courier.glober.infrastructure.entities.Customer;
import com.globant.courier.glober.infrastructure.repositories.jpa.CustomerJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @Autowired
    CustomerJpa customerJpa;

    public Customer save(Customer customer) {
        return customerJpa.save(customer);
    }


    public List<Customer> findAll() {
        return customerJpa.findAll();


    }
}