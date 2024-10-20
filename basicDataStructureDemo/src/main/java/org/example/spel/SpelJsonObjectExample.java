package org.example.spel;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;

public class SpelJsonObjectExample {
    public static void main(String[] args) {
        String jsonString = "{\"name\": \"Alice\", \"age\": 30, \"address\": {\"city\": \"Wonderland\", \"zipcode\": \"12345\"}}";
        JSONObject jsonObject = new JSONObject(jsonString);

        String modifiedJsonString = JsonPath.parse(jsonObject.toString())
                .set("$.name", "Alice Smith")
                .set("$.age", 31)
                .set("$.address.city", "New Wonderland")
                .set("$.address.zipcode", "54321")
                .jsonString();  // Convert back to string

        JSONObject modifiedJsonObject = new JSONObject(modifiedJsonString);

        System.out.println(modifiedJsonObject.toString(2));
    }
}