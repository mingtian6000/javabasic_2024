package org.example.yaml;

import org.example.entity.Person;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
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
        String yamlFile = "output.yaml";

        try (FileWriter writer = new FileWriter(yamlFile)) {
            yaml.dump(employees, writer); //or just use yaml.dump(employee)
            System.out.println("YAML write done");
            // output is bit wried, consider change person attr as public
        } catch (IOException e) {
            e.printStackTrace();
        }
        String yamlString = yaml.dump(employees);
        System.out.println(yamlString);

        List<Person> deserializedPersons = yaml.loadAs(yamlString, List.class);
        System.out.println("Deserialized Perons:");
        for (Person person : deserializedPersons) {
            System.out.println("Person: " + person);
        }
    }
}
