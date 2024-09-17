package org.example.json.orgDemo;

import org.example.entity.Address;
import org.example.entity.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        //demo1
        String jsonArrayString = "[{\"name\":\"Alice\",\"age\":30,\"address\":{\"street\":\"123 Main St\",\"city\":\"Wonderland\"}},"
                + "{\"name\":\"Bob\",\"age\":25,\"address\":{\"street\":\"456 Elm St\",\"city\":\"Wonderland\"}}]";
        convertJsonArr2Object(jsonArrayString);

        //demo2
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 30, new Address("123 Main St", "Wonderland", "123456")));
        personList.add(new Person("Bob", 25, new Address("456 Elm St", "Wonderland", null)));
        convertObject2JsonArr(personList);

    }
    public static void convertJsonArr2Object(String arrStr){
        JSONArray jsonArray = new JSONArray(arrStr);
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");

            JSONObject addressJson = jsonObject.getJSONObject("address");
            Address address = new Address(addressJson.getString("street"), addressJson.getString("city"), null);

            Person person = new Person(name, age, address);
            System.out.println(person);
            personList.add(person);
        }

    }
    public static void convertObject2JsonArr(List<Person> persons){
        JSONArray jsonArray = new JSONArray();

        for (Person person : persons) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", person.getName());
            jsonObject.put("age", person.getAge());
            JSONObject addressJson = new JSONObject();
            addressJson.put("street", person.getAddress().getStreet());
            addressJson.put("city", person.getAddress().getCity());

            jsonObject.put("address", addressJson);
            jsonArray.put(jsonObject);
        }
        System.out.println("JSON Array String: " + jsonArray);
    }
}
