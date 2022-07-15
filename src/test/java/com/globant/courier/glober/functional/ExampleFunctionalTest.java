package com.globant.courier.glober.functional;

import com.globant.courier.glober.domain.models.AccountDto;
import com.globant.courier.glober.infrastructure.entities.Account;
import com.globant.courier.glober.infrastructure.rest.input.FormatInput;
import com.globant.courier.glober.infrastructure.rest.output.FormatOutput;
import com.globant.courier.glober.infrastructure.util.ObjectMapperUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;


public class ExampleFunctionalTest {

    @Autowired
    TestRestTemplate restTemplate;

    int givenNumber;
    private Account account;

    @Given("given account number {int}")
    public void functional_the_maker_has_chosen_a_number(Integer idAccount) {
        givenNumber = idAccount;
        account = Account.builder()
                .uuidAccount(UUID.randomUUID())
                .idAccount(idAccount.toString())
                .type("S")
                .balance(idAccount.floatValue())
                .status("A")
                //.userAccount(accountInput.getUserAccount())
                //.creationUser(accountInput.getCreationUser())
                //.creationDate(new Date())
                .build();

        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/account/v1/save");

        FormatInput<AccountDto> formatInput = new FormatInput<>(ObjectMapperUtils.map(account, AccountDto.class));
        HttpEntity<FormatInput> request = new HttpEntity<>(formatInput, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(builder.toUriString(), request, String.class);

        Assertions.assertEquals(201,result.getStatusCodeValue());

    }


    @Then("Response code is {int}")
    public void response_code_is(Integer statusCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/account/v1/list");
        ResponseEntity<FormatOutput<AccountDto>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<>(){} );

        Assertions.assertEquals(statusCode,response.getStatusCode().value());
    }

}
