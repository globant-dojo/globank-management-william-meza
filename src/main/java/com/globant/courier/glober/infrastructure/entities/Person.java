package com.globant.courier.glober.infrastructure.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

//@Entity(name = "customer")
//@MappedSuperclass //class that is not persistent itself, but has subclasses that are persistent.
//@Getter
//@Setter
@SuperBuilder
public class Person {
    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "identification")
    private String identification;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    Person(){
    }
}
