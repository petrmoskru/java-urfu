package lr8.task1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import java.io.File;

public class CreateXMLFileLesson {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("lessons");
            doc.appendChild(rootElement);

            Element lesson1 = doc.createElement("lesson");
            rootElement.appendChild(lesson1);

            Element name1 = doc.createElement("name");
            name1.appendChild(doc.createTextNode("Математика"));
            lesson1.appendChild(name1);

            Element professor1 = doc.createElement("professor");
            professor1.appendChild(doc.createTextNode("Иван Иванович"));
            lesson1.appendChild(professor1);

            Element credits1 = doc.createElement("credits");
            credits1.appendChild(doc.createTextNode("5"));
            lesson1.appendChild(credits1);

            Element lesson2 = doc.createElement("lesson");
            rootElement.appendChild(lesson2);

            Element name2 = doc.createElement("name");
            name2.appendChild(doc.createTextNode("Программирование"));
            lesson2.appendChild(name2);

            Element professor2 = doc.createElement("professor");
            professor2.appendChild(doc.createTextNode("Мария Сергеевна"));
            lesson2.appendChild(professor2);

            Element credits2 = doc.createElement("credits");
            credits2.appendChild(doc.createTextNode("4"));
            lesson2.appendChild(credits2);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("java-core/src/lr8/task1/my_lessons.xml"));
            transformer.transform(source, result);
            System.out.println("XML-файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
