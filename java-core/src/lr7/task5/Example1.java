package lr7.task5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();
        System.out.print("Введите слово для поиска: ");
        String wordToSearch = scanner.nextLine();
        String filePath = "src/lr7/task5/" + fileName + ".txt";
        try {
            searchWordInFile(filePath, wordToSearch);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void searchWordInFile(String filePath, String wordToSearch) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Файл не найден.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordToSearch)) {
                    System.out.println(line);
                }
            }
        }
    }
}
