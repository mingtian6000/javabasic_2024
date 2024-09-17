package org.example.adapter;

import com.google.gson.*;
import org.example.entity.Address;

import java.lang.reflect.Type;

public class AddressAdapter implements JsonSerializer<Address>, JsonDeserializer<Address> {
    @Override
    public JsonElement serialize(Address address, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("street", address.getStreet());
        jsonObject.addProperty("city", address.getCity());
        if (address.getPostcode() != null) {
            jsonObject.addProperty("postcode", address.getPostcode());
        }
        return jsonObject;
    }

    @Override
    public Address deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String street = jsonObject.get("street").getAsString();
        String city = jsonObject.get("city").getAsString();
        String po = jsonObject.has("postcode") && !jsonObject.get("postcode").isJsonNull() ?
                jsonObject.get("postcode").getAsString() : null;
        return new Address(street, city, po);
    }
}

