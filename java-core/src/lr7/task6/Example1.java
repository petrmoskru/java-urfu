package lr7.task6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла для записи: ");
        String fileName = scanner.nextLine();
        System.out.print("Введите текст для записи в файл: ");
        String textToWrite = scanner.nextLine();
        String filePath = "src/lr7/task6/" + fileName + ".txt";
        try {
            writeToFile(filePath, textToWrite);
            System.out.println("Текст успешно записан в файл.");
            System.out.println("Количество записанных символов: " + textToWrite.length());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void writeToFile(String filePath, String textToWrite) throws IOException {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(textToWrite);
        }
    }
}
