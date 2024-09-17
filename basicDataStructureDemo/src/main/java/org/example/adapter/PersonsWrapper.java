package org.example.adapter;

import lombok.Data;
import org.example.entity.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "people") // Root element for collection
@XmlAccessorType(XmlAccessType.FIELD) // Use FIELD access type
@Data
public class PersonsWrapper {
    @XmlElement(name = "person") // Each person element in the list
    private List<Person> persons;

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}