package org.example.json.JacksonDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Address;
import org.example.entity.Person;

public class SimpleDemo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = """
                {"name":"Bob","age":27,"address":{"street":"123 Main St","city":"Henan","postcode":"627891"}}
                """;
        Person person = objectMapper.readValue(jsonStr, Person.class);
        System.out.println("Person is: " + person);
        //
        Address address = new Address("123 Main St", "Wonderland","123456");
        Person person1 = new Person("Alice", 30, address);
        String jsonString = objectMapper.writeValueAsString(person1);
        System.out.println("JSON String: " + jsonString);

    }
}
