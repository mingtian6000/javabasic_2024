package org.example.json.fastjsonDemo;
import com.alibaba.fastjson.JSON;
import org.example.entity.Person;

public class SimpleDemo {
    public static void main(String[] args) {
        String jsonStr = """
                {"name":"Bob","age":27}  //"address":{"street":"123 Main St","city":"Henan","postcode":"627891"}
                """;
        String jsonStr1 = """
                {"name":"Bob","age":27,"address":{"street":"123 Main St","city":"Henan","postcode":"627891"}}  //
                """;
        Person person = JSON.parseObject(jsonStr, Person.class);
        System.out.println("person without addr: " + person.toString());

        Person person1 = JSON.parseObject(jsonStr1, Person.class);
        System.out.println("person: " + person1.toString());
    }
}
