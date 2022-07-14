package com.globant.courier.glober.infrastructure.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity(name = "account")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
        @Id//retirar
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "uuid_account", nullable = false, columnDefinition = "uuid")
        @Type(type = "org.hibernate.type.PostgresUUIDType")
        private UUID uuidAccount;

        @Column(name = "id_account", length = 10, unique = true)
        private String idAccount;

        @Column(name = "type", length = 1)
        private String type;

        @Column(name = "balance")
        private Float balance;

        @Column(name = "status")
        private String status;
/*
        @Column(name = "creation_user")
        private String creationUser;

        @Column(name = "creation_date")
        private Date creationDate;

        @Column(name = "modification_user")
        private String modificationUser;

        @Column(name = "modification_date")
        private Date modificationDate;*/
    }