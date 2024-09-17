package org.example.yaml;

import org.example.entity.Address;
import org.example.entity.Person;
import org.yaml.snakeyaml.Yaml;

public class SnakeYamlSimpleDemo {

    public static void main(String[] args) {
        Yaml yaml = new Yaml();

        Person person = new Person("Alice", 30, new Address("WallStreet","NY","543000"));

        String yamlString = yaml.dump(person);
        System.out.println("Serialized YAML:" + yamlString);

        Person deserializedPerson = yaml.loadAs(yamlString, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson);

    }
}
