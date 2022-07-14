package com.globant.courier.glober.domain.usecases;

import com.globant.courier.glober.domain.models.CustomerDto;
import com.globant.courier.glober.domain.ports.repositories.ICustomerRepository;
import com.globant.courier.glober.domain.ports.services.ICustomerService;
import com.globant.courier.glober.infrastructure.entities.Customer;
import com.globant.courier.glober.infrastructure.rest.input.CustomerInput;
import com.globant.courier.glober.infrastructure.util.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository customerRepository){
        this.iCustomerRepository = customerRepository;
    }


    @Override
    public List<CustomerDto> findAll() {
        return ObjectMapperUtils.mapAll(this.iCustomerRepository.findAll(), CustomerDto.class);
    }



    @Transactional
    public CustomerDto save(CustomerInput customerInput) {
        Customer customer = Customer.builder()
                .uuidCustomer(UUID.randomUUID())
                .password(customerInput.getPassword())
                .status(customerInput.getStatus())
                .name(customerInput.getName())
                .sex(customerInput.getSex())
                .age(customerInput.getAge())
                .identification(customerInput.getIdentification())
                .address(customerInput.getAddress())
                .phone(customerInput.getPhone())
                .build();
        return ObjectMapperUtils.map(iCustomerRepository.save(customer), CustomerDto.class);
    }
}
