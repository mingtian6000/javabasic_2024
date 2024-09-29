package org.example.mvel;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.DocumentContext;

import java.util.HashMap;

public class Demo {

    public static void main(String[] args) {
        String jsonString = """
                {
                    "data": [
                        {
                            "id": 6,
                            "title": "how to learn C#",
                            "description": "C# programming",
                            "image": "",
                            "price": 65
                        }
                    ],
                    "header": {
                        "key1": "value1",
                        "key2": "value2"
                    }
                }
                """;
        DocumentContext jsonContext = JsonPath.parse(jsonString);

        // Modify the JSON object to add a new field "sts"
        jsonContext.put("$..data[0]", "sts", new HashMap<String, Object>() {{
            put("cancel", 0);
        }});
        jsonContext.put("$..data[0].abc", "abcd", new HashMap<String, Object>() {{
            put("key3", "value3");
        }});

        String modifiedJson = jsonContext.jsonString();
        System.out.println(modifiedJson);
    }
}
