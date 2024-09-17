package org.example.json.gsonDemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entity.Address;
import org.example.entity.Person;

public class SimplestJsonDemo {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30, new Address("123 Main St", "Wonderland", "510000"));
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().serializeNulls().setLenient().create(); //  if attr is null
        String json = gson.toJson(person);
        System.out.println(json);

        //
        String jsonStr = """
                {"name":"Bob","age":27}  //"address":{"street":"123 Main St","city":"Henan","postcode":"627891"}
                """;
        Person personObj = gson.fromJson(jsonStr, Person.class);
        System.out.println("Name: " + personObj.getName());
        System.out.println("Age: " + personObj.getAge());
        System.out.println("Addr: " + personObj.getAddress());
    }

}
