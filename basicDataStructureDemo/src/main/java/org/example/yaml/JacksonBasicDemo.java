package org.example.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.entity.Address;
import org.example.entity.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonBasicDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 30, null));
        persons.add(new Person("Bob", 25, new Address("BeautifullHouse","NewYork","123456")));
        persons.add(new Person("Charlie", 35, null));

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            mapper.writeValue(new File("persons.yaml"), persons);
            System.out.println("YAML write successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<Person> readPersons = mapper.readValue(new File("persons.yaml"), mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
            System.out.println("YAML read successfully");
            for (Person person : readPersons) {
                System.out.println(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
