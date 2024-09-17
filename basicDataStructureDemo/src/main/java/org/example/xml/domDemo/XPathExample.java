package org.example.xml.domDemo;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

public class XPathExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream xmlStream = DomExample.class.getClassLoader().getResourceAsStream("people.xml");
            Document document = builder.parse(xmlStream);

            XPath xPath = XPathFactory.newInstance().newXPath();

            // Example 1: Find all names
            String expression = "/people/person/name";
            NodeList nameNodes = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);
            System.out.println("Names:");
            for (int i = 0; i < nameNodes.getLength(); i++) {
                System.out.println(nameNodes.item(i).getTextContent());
            }

            // Example 2: Find person by name
            String personName = "Bob";
            expression = "/people/person[name='" + personName + "']";
            NodeList personNodes = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);
            System.out.println("\nDetails of " + personName + ":");
            if (personNodes.getLength() > 0) {
                System.out.println("Name: " + personNodes.item(0).getChildNodes().item(0).getTextContent());
                System.out.println("Age: " + personNodes.item(0).getChildNodes().item(1).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
