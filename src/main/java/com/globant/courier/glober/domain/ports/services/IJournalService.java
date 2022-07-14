package com.globant.courier.glober.domain.ports.services;

import com.globant.courier.glober.domain.models.AccountDto;
import com.globant.courier.glober.domain.models.JournalDto;
import com.globant.courier.glober.infrastructure.rest.input.AccountInput;
import com.globant.courier.glober.infrastructure.rest.input.JournalInput;

import java.util.List;

public interface IJournalService {
	JournalDto save(JournalInput journalInput);
}
