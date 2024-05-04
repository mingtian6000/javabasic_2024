package demo.vendors;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class DOMParserExample {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("basicIOStreamDemo\\src\\main\\resources\\data.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            Element root = document.getDocumentElement();
            NodeList personList = root.getElementsByTagName("person");

            for (int i = 0; i < personList.getLength(); i++) {
                Element person = (Element) personList.item(i);
                String name = person.getElementsByTagName("name").item(0).getTextContent();
                int age = Integer.parseInt(person.getElementsByTagName("age").item(0).getTextContent());
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
