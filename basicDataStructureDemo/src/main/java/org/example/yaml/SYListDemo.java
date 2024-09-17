package org.example.yaml;

import org.example.entity.Person;
import org.yaml.snakeyaml.Yaml;

import java.util.Arrays;
import java.util.List;

public class SYListDemo {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();

        // Create a list of Employee objects
        List<Person> employees = Arrays.asList(
                new Person("Alice", 23,null),
                new Person("Bob", 32, null)
        );

        String yamlString = yaml.dump(employees);
        System.out.println(yamlString);

        List<Person> deserializedPersons = yaml.loadAs(yamlString, List.class);
        System.out.println("Deserialized Perons:");
        for (Person person : deserializedPersons) {
            System.out.println("Person: " + person);
        }
    }
}
