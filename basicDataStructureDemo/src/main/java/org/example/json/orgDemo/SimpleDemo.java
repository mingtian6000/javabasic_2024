package org.example.json.orgDemo;

import org.example.entity.Address;
import org.example.entity.Person;
import org.json.JSONObject;

public class SimpleDemo {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Wonderland","510 000");
        Person person = new Person("Alice", 30, address);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", person.getName());
        jsonObject.put("age", person.getAge());

        JSONObject addressJson = new JSONObject();
        addressJson.put("street", person.getAddress().getStreet());
        addressJson.put("city", person.getAddress().getCity());

        jsonObject.put("address", addressJson);
        System.out.println("JSON String: " + jsonObject);

        String jsonString = "{\"name\":\"Bob\",\"age\":20,\"address\":{\"street\":\"123 Main St\",\"city\":\"Wonderland123\",\"postcode\":\"1234567\"}}";

        // Convert JSON String back to Person object
        JSONObject jsonObj = new JSONObject(jsonString);
        String name = jsonObj.getString("name");
        int age = jsonObj.getInt("age");

        JSONObject addrJson = jsonObj.getJSONObject("address");
        Address addr = new Address(addrJson.getString("street"), addrJson.getString("city"), addrJson.getString("postcode"));

        Person person1 = new Person(name, age, addr);
        System.out.println(person1);

    }
}
