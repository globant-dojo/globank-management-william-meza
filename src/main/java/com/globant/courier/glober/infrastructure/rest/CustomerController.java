package com.globant.courier.glober.infrastructure.rest;

import com.globant.courier.glober.domain.models.CustomerDto;
import com.globant.courier.glober.domain.ports.services.ICustomerService;
import com.globant.courier.glober.infrastructure.rest.input.AccountInput;
import com.globant.courier.glober.infrastructure.rest.input.CustomerInput;
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
@RequestMapping("/customer/v1")
@CrossOrigin
@Slf4j
public class CustomerController {

	@Autowired
	private ICustomerService iCustomerService;

	@GetMapping("/list")
	@Operation(description = "get customers")
	public ResponseEntity<FormatOutput<CustomerDto>> findByAll()  {

		HttpStatus status = HttpStatus.OK;
		List<CustomerDto> customersDto = null;
		MultiValueMap<String, String> header = new HttpHeaders();
		try {
			customersDto = iCustomerService.findAll();
			if (customersDto == null || customersDto.isEmpty())
				status = HttpStatus.NOT_FOUND;

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		FormatOutput<CustomerDto> output = new FormatOutput<>();
		output.setData(customersDto);
		output.setMessages(Arrays.asList(new FormatMessage(String.valueOf(status.value()), status.getReasonPhrase())));

		header.set("version","1.0.0-SNAPSHOT");
		return new ResponseEntity<>(output, header, status);
	}


	@PostMapping("/save")
	@Operation(description = "save customer")
	public ResponseEntity<FormatOutput<CustomerDto>> save(@Valid @RequestBody FormatInput<CustomerInput> input)  {
		HttpStatus status = HttpStatus.CREATED;
		CustomerDto customerDto = iCustomerService.save(input.getData());
		FormatMessage message = new FormatMessage(String.valueOf(status.value()), status.getReasonPhrase());
		FormatOutput<CustomerDto> formatOutput = new FormatOutput<>(List.of(customerDto), List.of(message));
		return new ResponseEntity<>(formatOutput, status);
	}
}
