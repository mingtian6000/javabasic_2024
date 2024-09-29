package org.example.mvel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mvel2.MVEL;

import java.util.*;

public class Test {
    public static void main(String[] args) {

            String jsonString = """
                    {
                        "data": [
                            {
                                "id": 6,
                                "title": "how to learn C#",
                                "description": "C# programming",
                                "image": "",
                                "price": 65,
                                "sts": { "cancel": 0 }
                            }
                        ],
                        "header": {
                            "key1": "value1",
                            "key2": "value2"
                        }
                    }
                    """;
        updateJsonObj(jsonString);
        updateMap();
        selectOnArray(); // seems map will be more smooth?
        useContext(); //demo how context is being used
        useComplicatedContext();
    }

    private static  void updateJsonObj(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});

            String expression = "data[0][\"sts\"] = \"abc\"";
            String expression1 = "header[\"sts\"] = \"abc\""; // do not consecutively exec 2 expressions on same obj!

            MVEL.eval(expression1, jsonMap);
            String modifiedJson = objectMapper.writeValueAsString(jsonMap);
            jsonMap=objectMapper.readValue(modifiedJson, new TypeReference<Map<String, Object>>() {});
            MVEL.eval(expression, jsonMap);
            modifiedJson = objectMapper.writeValueAsString(jsonMap);
            System.out.println(modifiedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateMap(){
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Alice");
        user.put("address", new HashMap<String, Object>() {{
            put("city", "Wonderland");
            put("zipcode", "12345");
        }});
        System.out.println(user);
        String expression = "address[\"city\"] = 'New Wonderland'";
        MVEL.eval(expression, user);
        System.out.println(user);
    }
    private static void selectOnArray(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MVEL.eval("this.add(6)", numbers);
        //List<Integer> evens = (List<Integer>) MVEL.eval("this.stream().filter{n % 2 == 0}.collect(Collectors.toList())", numbers);
        //List<Integer> evens = (List<Integer>) MVEL.eval("this.collect { it % 2 == 0 ? it : null }.findAll { it != null }", numbers);
        List<Integer> evens = new ArrayList<>();

        //The error you're encountering is due to how MVEL handles method calls on Java collections. The filter method is part of the Stream API,
        // which cannot be directly invoked as you would in a normal Java environment. MVEL does not support directly chaining Stream operations .
        String expression = "foreach (n : numbers) { if (n % 2 == 0) { evens.add(n) } }";

        Map<String, Object> context = Map.of("numbers", numbers, "evens", evens);
        MVEL.eval(expression, context);
        System.out.println(evens);
    }

    private static void useContext(){
        Map<String, Object> context = new HashMap<>();
        context.put("basePrice", 100);
        context.put("taxRate", 0.2);

        String expression = "basePrice + (basePrice * taxRate)";
        Double totalPrice = (Double) MVEL.eval(expression, context);

        System.out.println(totalPrice);
    }

    private static void useComplicatedContext(){
        Map<String, Object> order = new HashMap<>();
        order.put("id", 1);
        order.put("items", new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>() {{
                put("name", "Item A");
                put("quantity", 2);
                put("price", 25);
            }});
            add(new HashMap<String, Object>() {{
                put("name", "Item B");
                put("quantity", 1);
                put("price", 50);
            }});
        }});
        //cannot use collect function on iterator items, and do not use this to reference!!
/*        String expression = "items.collect { it.price * it.quantity }.sum()";
        Double totalOrderPrice = (Double) MVEL.eval(expression, order);
        System.out.println(totalOrderPrice);*/
        String expression1 = "total = 0; foreach (item : items) { total += item.price * item.quantity }; total";
        Integer totalOrderPrice1 = (Integer) MVEL.eval(expression1, order);
        System.out.println(totalOrderPrice1);
    }
}