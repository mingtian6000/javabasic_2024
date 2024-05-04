package demo.vendors;

import org.json.*;
public class JSONParserExample {

    public static void main(String[] args) {
        try {
            String jsonStr = """
                    {
                      "name": "John Doe",
                      "age": 30,
                      "address": {
                        "street": "123 Main St",
                        "city": "New York"
                      },
                      "hobbies": ["reading", "traveling", "cooking"]
                    }
                    """;

            JSONObject jsonObject = new JSONObject(jsonStr);
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            JSONObject address = jsonObject.getJSONObject("address");
            String street = address.getString("street");
            String city = address.getString("city");
            JSONArray hobbies = jsonObject.getJSONArray("hobbies");

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Street: " + street);
            System.out.println("City: " + city);
            System.out.println("Hobbies: " + hobbies.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
