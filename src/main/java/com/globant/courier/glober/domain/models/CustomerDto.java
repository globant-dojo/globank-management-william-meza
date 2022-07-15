package com.globant.courier.glober.domain.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
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
