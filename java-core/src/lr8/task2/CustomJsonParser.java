package lr8.task2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomJsonParser {
    private static final String JSON_FILE_PATH = "java-core/src/lr8/task2/example-json.json";

    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(JSON_FILE_PATH));
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            System.out.println("Корневой элемент: books");
            printBookDetails(jsonArray);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Хотите ли вы добавить новые книги? (Да или Нет): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("да")) {
                addNewBook(scanner, jsonArray);
            }

            System.out.print("Хотите ли вы найти книгу по автору и году? (Да или Нет): ");
            String answer1 = scanner.nextLine();
            if (answer1.equalsIgnoreCase("да")) {
                findBookByAuthorAndYear(scanner, jsonArray);
            }

            System.out.print("Хотите ли вы удалить книгу? (Да или Нет): ");
            String answer2 = scanner.nextLine();
            if (answer2.equalsIgnoreCase("да")) {
                removeBook(scanner, jsonObject, jsonArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printBookDetails(JSONArray jsonArray) {
        for (Object o : jsonArray) {
            JSONObject book = (JSONObject) o;
            System.out.println("\nТекущий элемент: book");
            System.out.println("Название книги: " + book.get("title"));
            System.out.println("Автор: " + book.get("author"));
            System.out.println("Год издания: " + book.get("year"));
        }
    }

    private static void addNewBook(Scanner scanner, JSONArray jsonArray) throws IOException {
        System.out.print("Введите название книги: ");
        String nameBook = scanner.nextLine();
        System.out.print("Введите имя автора: ");
        String author = scanner.nextLine();
        System.out.print("Введите год издания: ");
        String year = scanner.nextLine();

        JSONObject newBook = new JSONObject();
        newBook.put("title", nameBook);
        newBook.put("author", author);
        newBook.put("year", year);

        jsonArray.add(newBook);
        saveChanges(jsonArray);
        System.out.println("JSON-файл успешно дополнен!");
    }

    private static void saveChanges(JSONArray jsonArray) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("books", jsonArray);

        try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
            file.write(jsonObject.toJSONString());
        }
    }

    private static void findBookByAuthorAndYear(Scanner scanner, JSONArray jsonArray) {
        System.out.print("Введите имя автора: ");
        String nameAuthor = scanner.nextLine();
        System.out.print("Введите год издания: ");
        String yearForSearch = scanner.nextLine();

        boolean found = false;
        for (Object o : jsonArray) {
            JSONObject book = (JSONObject) o;
            if (book.get("author").equals(nameAuthor) && book.get("year").equals(yearForSearch)) {
                System.out.println("Книга найдена: " + book.get("title"));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Такой книги нет");
        }
    }

    private static void removeBook(Scanner scanner, JSONObject jsonObject, JSONArray jsonArray) throws IOException {
        System.out.print("Введите название книги: ");
        String titleBook = scanner.nextLine();

        boolean removed = false;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject book = (JSONObject) jsonArray.get(i);
            if (titleBook.equals(book.get("title"))) {
                jsonArray.remove(i);
                removed = true;
                System.out.println("Книга удалена!");
            }
        }
        if (!removed) {
            System.out.println("Такой книги нет");
        }
        saveChanges(jsonArray);
    }
}
