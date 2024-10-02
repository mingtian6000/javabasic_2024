package demo.vendors;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("basicIOStreamDemo\\src\\main\\resources\\data.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean isName = false;
                boolean isAge = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        isName = true;
                    } else if (qName.equalsIgnoreCase("age")) {
                        isAge = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (isName) {
                        System.out.println("Name: " + new String(ch, start, length));
                        isName = false;
                    } else if (isAge) {
                        System.out.println("Age: " + new String(ch, start, length));
                        isAge = false;
                    }
                }
            };

            parser.parse(xmlFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
