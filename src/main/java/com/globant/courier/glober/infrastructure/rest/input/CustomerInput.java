package com.globant.courier.glober.infrastructure.rest.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
public class CustomerInput {
    private UUID uuidCustomer;
    private String password;
    private String status;
    private String name;
    private String sex;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
}
