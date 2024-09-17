package org.example.xml.saxDemo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

public class SaxDemo {
    public static void main(String[] args) {
        try {
            InputStream xmlStream = SaxDemo.class.getClassLoader().getResourceAsStream("people.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean name = false;
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        name = false;
                    }
                }
            };
           // InputStream xmlStream = DomExample.class.getClassLoader().getResourceAsStream("people.xml");
            saxParser.parse(xmlStream, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
