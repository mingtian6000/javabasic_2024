package org.example.xml.jaxbDemo;

import org.example.adapter.PersonsWrapper;
import org.example.entity.Address;
import org.example.entity.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

public class SimpleDemo {

    public static void main(String[] args) {
        //marshallerDemo();
        //listDemo();
        unmarshallerDemo();
    }

    private static void marshallerDemo(){
        try {
            // Create a Person object
            Address address = new Address("123 Main St", "Wonderland","510 000");
            Person person = new Person("Alice", 30, address);

            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(person, System.out); // Output to console
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private static void unmarshallerDemo(){
        try {
            String xmlOutput= """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <people>
                        <person>
                            <name>Alice</name>
                            <age>30</age>
                        </person>
                        <person>
                            <name>Bob</name>
                            <age>25</age>
                            <address>
                                <street>abc</street>
                                <city>Henan</city>
                                <postcode>473000</postcode>
                            </address>
                        </person>
                    </people>
                    """;
            JAXBContext context = JAXBContext.newInstance(PersonsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlOutput);
            PersonsWrapper deserializedWrapper = (PersonsWrapper) unmarshaller.unmarshal(reader);

            // Display deserialized data
            for (Person person : deserializedWrapper.getPersons()) {
                System.out.println("Name: " +person);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    private static void listDemo(){
        try {
            // Create a list of employees (Persons)
            List<Person> persons = Arrays.asList(
                    new Person("Alice", 30, null),
                    new Person("Bob", 25, new Address("abc", "Henan", "473000"))
            );
            JAXBContext context = JAXBContext.newInstance(PersonsWrapper.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            PersonsWrapper wrapper = new PersonsWrapper();
            wrapper.setPersons(persons);
            marshaller.marshal(wrapper, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
