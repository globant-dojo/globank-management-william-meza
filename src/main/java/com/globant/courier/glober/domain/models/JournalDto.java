package com.globant.courier.glober.domain.models;

import com.globant.courier.glober.infrastructure.entities.Account;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalDto {
	private UUID uuidJournal;
	private Date creationDate;
	private String type;
	private Float amount;
	private Float balance;
	private UUID uuidAccount;

}
