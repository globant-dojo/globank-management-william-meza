package com.globant.courier.glober.infrastructure.rest;

import com.globant.courier.glober.domain.models.AccountDto;

import com.globant.courier.glober.domain.ports.services.IAccountService;
import com.globant.courier.glober.infrastructure.rest.input.AccountInput;
import com.globant.courier.glober.infrastructure.rest.input.FormatInput;
import com.globant.courier.glober.infrastructure.rest.output.FormatMessage;
import com.globant.courier.glober.infrastructure.rest.output.FormatOutput;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/account/v1")
@CrossOrigin
@Slf4j
public class AccountController {

	@Autowired
	private IAccountService iAccountService;

	@GetMapping("/list")
	@Operation(description = "get accounts")
	public ResponseEntity<FormatOutput<AccountDto>> findByAll()  {
		//log.info(" {}", );

		HttpStatus status = HttpStatus.OK;
		List<AccountDto> accountsDto = null;
		MultiValueMap<String, String> header = new HttpHeaders();
		try {
			accountsDto = iAccountService.findAll();
			if (accountsDto == null || accountsDto.isEmpty())
				status = HttpStatus.NOT_FOUND;

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		FormatOutput<AccountDto> output = new FormatOutput<>();
		output.setData(accountsDto);
		output.setMessages(Arrays.asList(new FormatMessage(String.valueOf(status.value()), status.getReasonPhrase())));

		header.set("version","1.0.0-SNAPSHOT");
		return new ResponseEntity<>(output, header, status);
	}


	@PostMapping("/save")
	@Operation(description = "save account")
	public ResponseEntity<FormatOutput<AccountDto>> save(@Valid @RequestBody FormatInput<AccountInput> input)  {
		HttpStatus status = HttpStatus.CREATED;
		AccountDto accountDto = iAccountService.save(input.getData());
		FormatMessage message = new FormatMessage(String.valueOf(status.value()), status.getReasonPhrase());
		FormatOutput<AccountDto> formatOutput = new FormatOutput<>(List.of(accountDto), List.of(message));
		return new ResponseEntity<>(formatOutput, status);
	}
}
