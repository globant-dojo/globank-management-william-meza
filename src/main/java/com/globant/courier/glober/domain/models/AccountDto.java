package com.globant.courier.glober.domain.models;

import com.globant.courier.glober.infrastructure.util.JsonMapper;
import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
	private UUID uuidAccount;
	private String idAccount;
	private String type;
	private Float balance;
	private String status;

//	public AccountDto(UUID catalogId, String description, String value, Long order, UUID catalogTypeId){
//		this.catalogId = catalogId;
//		this.order = order;
//		this.description = description;
//		this.catalogTypeId = catalogTypeId;
//		this.value = JsonMapper.convertStringToMap(value);
//	}

}
