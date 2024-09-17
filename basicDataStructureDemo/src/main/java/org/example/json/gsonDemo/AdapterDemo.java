package org.example.json.gsonDemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.adapter.AddressAdapter;
import org.example.adapter.PersonAdapter;
import org.example.entity.Address;
import org.example.entity.Person;

public class AdapterDemo {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder().serializeNulls().setLenient();
        builder.registerTypeAdapter(Address.class, new AddressAdapter());
        builder.registerTypeAdapter(Person.class, new PersonAdapter());
        Gson gson = builder.create();

        // Create a Person with an Address
        Address address = new Address("123 Main St", "Wonderland","510000");
        Person person = new Person("Alice", 30, address);

        // Serialize
        String json = gson.toJson(person);
        System.out.println("Serialized JSON: " + json);

        // Deserialize
        String jsonString = "{\"fullName\":\"Alice\",\"yearsOld\":30,\"address\":{\"street\":\"123 Main St\",\"city\":\"Wonderland\"}}";
        Person deserializedPerson = gson.fromJson(jsonString, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson.getName() + ", address city: " + deserializedPerson.getAddress().getCity());
    }
}
