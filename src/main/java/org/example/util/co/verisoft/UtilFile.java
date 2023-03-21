package org.example.util.co.verisoft;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The UtilFile class provides utility methods for working with files.
 */

public class UtilFile {
    /**
     * Returns a list of strings from an XML file with the specified list name.
     *
     * @param listName the name of the list in the XML file
     * @return a list of strings from the XML file
     */
    public static List<String> getListFromXml(String listName) {

        List<String> list = new ArrayList<>();
        try {
            File file = new File(System.getProperty("user.dir") + "\\DataConfiguration.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName(listName);
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                NodeList childNodes = element.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node childNode = childNodes.item(i);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNode;
                        String value = childElement.getTextContent();
                        list.add(value);
                    }
                }
            }
        } catch (Exception e) {
            //log.info("");
        }
        return list;
    }


    /**
     * Returns the value of the specified node in an XML file.
     *
     * @param nodeName the name of the node in the XML file
     * @return the value of the node in the XML file
     */
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File(System.getProperty("user.dir") + "\\DataConfiguration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse((fXmlFile));
        } catch (Exception e) {
            System.out.println(e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
}
