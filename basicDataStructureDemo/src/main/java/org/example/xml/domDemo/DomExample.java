package org.example.xml.domDemo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;

public class DomExample {
    public static void main(String[] args) {
        try {
            InputStream xmlStream = DomExample.class.getClassLoader().getResourceAsStream("people.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlStream);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("person");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element person = (Element) nodeList.item(i);
                System.out.println("Name: " + person.getElementsByTagName("name").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}