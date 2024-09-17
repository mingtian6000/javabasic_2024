package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement
    @JsonProperty("name")
    private String name;

    @XmlElement
    @JsonProperty("age")
    private int age;

    @XmlElement
    @JsonProperty("address")
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Person() {} // Default constructor for Jackson
}

