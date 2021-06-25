package it.ssm.tools;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

public class xml2hashmap {
    static public String getAttribute(String input,String Tag) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        org.jdom2.Document document = saxBuilder.build(new InputSource(new StringReader(input)));
        org.jdom2.Element root = document.getRootElement();

        List<Element> listElement = root.getChildren();

        HashMap<String, String> sh = new HashMap<>();
        for (org.jdom2.Element e:listElement) {
            if (Tag.equals(e.getName())){
                return e.getTextTrim();
            }
        }
        return null;

    }

    static public HashMap<String, String> getAttribute(String input) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        org.jdom2.Document document = saxBuilder.build(new InputSource(new StringReader(input)));
        org.jdom2.Element root = document.getRootElement();

        List<Element> listElement = root.getChildren();

        HashMap<String, String> sh = new HashMap<>();
        for (org.jdom2.Element e:listElement) {
            sh.put(e.getName(),e.getTextTrim());

        }
        System.out.println(sh);
        return sh;

    }
}
