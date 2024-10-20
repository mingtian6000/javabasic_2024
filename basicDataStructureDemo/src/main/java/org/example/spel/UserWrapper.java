package org.example.spel;

import org.json.JSONObject;

public class UserWrapper {
    private JSONObject jsonObject;

    public UserWrapper(String jsonString) {
        this.jsonObject = new JSONObject(jsonString);
    }

    public String getName() {
        return jsonObject.getString("name");
    }

    public void setName(String name) {
        jsonObject.put("name", name);
    }

    public int getAge() {
        return jsonObject.getInt("age");
    }

    public void setAge(int age) {
        jsonObject.put("age", age);
    }

    public JSONObject getAddress() {
        return jsonObject.getJSONObject("address");
    }

    public void setAddress(String city, String zipcode) {
        JSONObject address = jsonObject.getJSONObject("address");
        address.put("city", city);
        address.put("zipcode", zipcode);
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}
