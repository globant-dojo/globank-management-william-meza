package com.globant.courier.glober.infrastructure.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "customer")
//@DiscriminatorValue("customer")
//@PrimaryKeyJoinColumn(name = "uuid_customer")
@Getter
@Setter
@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
public class Customer extends Person{
    @Id//retirar
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid_customer", nullable = false, columnDefinition = "uuid")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID uuidCustomer;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    public Customer(){
        super();
    }
}
