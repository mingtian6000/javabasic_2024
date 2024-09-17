package org.example.xml.jacksonDemo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.entity.Address;
import org.example.entity.Person;

public class SimpleDemo {
    public static void main(String[] args) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            Person person = new Person("Bob", 25, new Address("abc","Wallstreet103", "510 000"));

            // Serialize the Person object to XML
            String xmlString = xmlMapper.writeValueAsString(person);
            System.out.println("Serialized XML:\n" + xmlString);

            // Deserialize XML back to Person object
            Person deserializedPerson = xmlMapper.readValue(xmlString, Person.class);
            System.out.println("Deserialized Person: Name = " + deserializedPerson.getName() + ", Age = " + deserializedPerson.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
