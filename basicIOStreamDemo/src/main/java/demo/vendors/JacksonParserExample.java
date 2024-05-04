package demo.vendors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
public class JacksonParserExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File("basicIOStreamDemo\\src\\main\\resources\\data.json");

            JsonNode rootNode = objectMapper.readTree(jsonFile);
            String name = rootNode.get("name").asText();
            int age = rootNode.get("age").asInt();
            String street = rootNode.get("address").get("street").asText();
            String city = rootNode.get("address").get("city").asText();
            JsonNode hobbies = rootNode.get("hobbies");

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Street: " + street);
            System.out.println("City: " + city);
            System.out.println("Hobbies: " + hobbies.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
