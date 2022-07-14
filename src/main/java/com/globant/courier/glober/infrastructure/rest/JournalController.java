package com.globant.courier.glober.infrastructure.rest;

import com.globant.courier.glober.domain.models.JournalDto;
import com.globant.courier.glober.domain.ports.services.IAccountService;
import com.globant.courier.glober.domain.ports.services.IJournalService;
import com.globant.courier.glober.infrastructure.rest.input.AccountInput;
import com.globant.courier.glober.infrastructure.rest.input.FormatInput;
import com.globant.courier.glober.infrastructure.rest.input.JournalInput;
import com.globant.courier.glober.infrastructure.rest.output.FormatMessage;
import com.globant.courier.glober.infrastructure.rest.output.FormatOutput;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/journal/v1")
@CrossOrigin
@Slf4j
public class JournalController {

	@Autowired
	private IJournalService iJournalService;

	@PostMapping("/save")
	@Operation(description = "save journal")
	public ResponseEntity<FormatOutput<JournalDto>> save(@Valid @RequestBody FormatInput<JournalInput> input)  {
		HttpStatus status = HttpStatus.CREATED;
		JournalDto journalDto = iJournalService.save(input.getData());
		FormatMessage message = new FormatMessage(String.valueOf(status.value()), status.getReasonPhrase());
		FormatOutput<JournalDto> formatOutput = new FormatOutput<>(List.of(journalDto), List.of(message));
		return new ResponseEntity<>(formatOutput, status);
	}
}
