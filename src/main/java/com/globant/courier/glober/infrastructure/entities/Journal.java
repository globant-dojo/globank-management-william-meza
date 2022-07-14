package com.globant.courier.glober.infrastructure.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "journal")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid_journal", nullable = false, columnDefinition = "uuid")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID uuidJournal;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "type", length = 1)
    private String type;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "balance")
    private Float balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuid_account", insertable = false, updatable = false)
    private Account account;
}
