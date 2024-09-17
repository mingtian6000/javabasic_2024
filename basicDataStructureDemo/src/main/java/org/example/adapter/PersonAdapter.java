package org.example.adapter;
import com.google.gson.*;
import org.example.entity.Address;
import org.example.entity.Person;

import java.lang.reflect.Type;

public class PersonAdapter implements JsonSerializer<Person>, JsonDeserializer<Person> {
    @Override
    public JsonElement serialize(Person person, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("fullName", person.getName());
        jsonObject.addProperty("yearsOld", person.getAge());
        jsonObject.add("address", context.serialize(person.getAddress()));
        return jsonObject;
    }

    @Override
    public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String name = jsonObject.get("fullName").getAsString();
        int age = jsonObject.get("yearsOld").getAsInt();
        Address address = context.deserialize(jsonObject.get("address"), Address.class);
        return new Person(name, age, address);
    }
}
