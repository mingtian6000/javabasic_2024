package org.example.xml.saxDemo;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXDemo {
    public static void main(String[] args) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            InputStream xmlStream = SaxDemo.class.getClassLoader().getResourceAsStream("people.xml");
            XMLStreamReader reader = factory.createXMLStreamReader(xmlStream);

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if ("name".equals(reader.getLocalName())) {
                        System.out.println("Name: " + reader.getElementText());
                    }
                    if("age".equals(reader.getLocalName())){
                        System.out.println("age: " + reader.getElementText());
                    }
                    //what if it is xmlElements??
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
