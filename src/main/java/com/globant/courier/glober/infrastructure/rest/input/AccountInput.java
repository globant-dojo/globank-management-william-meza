package com.globant.courier.glober.infrastructure.rest.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class AccountInput {

    @NotEmpty(message = "idAccount must no be empty")
    //@Pattern(regexp = "^\\d{9}$")
    private String idAccount;

    @NotEmpty(message = "type must no be empty")
    private String type;

    //@NotEmpty(message = "balance must no be empty")
    private Float balance;

    @NotEmpty(message = "status must no be empty")
    private String status;

}
