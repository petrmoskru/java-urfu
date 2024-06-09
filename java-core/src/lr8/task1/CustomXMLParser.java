package lr8.task1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class CustomXMLParser {
    private static final String XML_FILE_PATH = "java-core/src/lr8/task1/example.xml";

    public static void main(String[] args) {
        try {
            File inputFile = new File(XML_FILE_PATH);
            Document doc = getDocument(inputFile);
            NodeList nodeList = doc.getElementsByTagName("book");

            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            printBookDetails(nodeList);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Хотите ли вы добавить новые книги? (Да или Нет): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("да")) {
                addNewBook(scanner, doc);
            }

            System.out.print("Хотите ли вы найти книгу по автору и году? (Да или Нет): ");
            String answer1 = scanner.nextLine();
            if (answer1.equalsIgnoreCase("да")) {
                findBookByAuthorAndYear(scanner, nodeList);
            }

            System.out.print("Хотите ли вы удалить книгу? (Да или Нет): ");
            String answer2 = scanner.nextLine();
            if (answer2.equalsIgnoreCase("да")) {
                removeBook(scanner, doc, nodeList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document getDocument(File inputFile) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(inputFile);
    }

    private static void printBookDetails(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                System.out.println("Название книги: " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
            }
        }
    }

    private static void addNewBook(Scanner scanner, Document doc) throws Exception {
        System.out.print("Введете название книги: ");
        String nameBook = scanner.nextLine();
        System.out.print("Введете имя автора: ");
        String author = scanner.nextLine();
        System.out.print("Введете год издания: ");
        String year = scanner.nextLine();

        Element root = doc.getDocumentElement();
        Element newBook = doc.createElement("book");
        root.appendChild(newBook);

        newBook.appendChild(createElement(doc, "title", nameBook));
        newBook.appendChild(createElement(doc, "author", author));
        newBook.appendChild(createElement(doc, "year", year));

        saveChanges(doc);
        System.out.println("XML-файл успешно дополнен!");
    }

    private static Element createElement(Document doc, String tagName, String textContent) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(textContent));
        return element;
    }

    private static void saveChanges(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(XML_FILE_PATH));
        transformer.transform(source, result);
    }

    private static void findBookByAuthorAndYear(Scanner scanner, NodeList nodeList) {
        System.out.print("Введите имя автора: ");
        String nameAuthor = scanner.nextLine();
        System.out.print("Введите год для поиска: ");
        String yearForSearch = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getElementsByTagName("author").item(0).getTextContent().equals(nameAuthor)
                        && element.getElementsByTagName("year").item(0).getTextContent().equals(yearForSearch)) {
                    System.out.println("Книга найдена! Имя книги: " + element.getElementsByTagName("title").item(0).getTextContent());
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Такой книги нет");
        }
    }

    private static void removeBook(Scanner scanner, Document doc, NodeList nodeList) throws Exception {
        System.out.print("Введите название книги: ");
        String titleBook = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getElementsByTagName("title").item(0).getTextContent().equals(titleBook)) {
                    Node parentNode = element.getParentNode();
                    parentNode.removeChild(element);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Такой книги нет");
        } else {
            saveChanges(doc);
            System.out.println("Книга успешно удалена!");
        }
    }
}
