package org.example.json.JacksonDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Address;
import org.example.entity.Person;

import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        try {
            // JSON Array String
            String jsonArrayString = "[{\"name\":\"Alice\",\"age\":30,\"address\":{\"street\":\"123 Main St\",\"city\":\"Wonderland\"}},"
                    + "{\"name\":\"Bob\",\"age\":25,\"address\":{\"street\":\"456 Elm St\",\"city\":\"Wonderland\"}}]";

            ObjectMapper objectMapper = new ObjectMapper();
            List<Person> personList = objectMapper.readValue(jsonArrayString, new TypeReference<>() {}); // similar to Gson
            for (Person person : personList) {
                System.out.println("Person is: " + person);
            }

            //
            // Create a List of Person Objects
            Address address1 = new Address("123 Main St", "Wonderland","510000");
            Person person1 = new Person("Alice", 30, address1);

            Address address2 = new Address("456 Elm St", "Wonderland123", "473000");
            Person person2 = new Person("Bob", 25, address2);

            List<Person> personList1 = List.of(person1, person2);
            String jsonArrString = objectMapper.writeValueAsString(personList1);
            System.out.println("JSON Array String: " + jsonArrString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
