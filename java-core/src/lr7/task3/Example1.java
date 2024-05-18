package lr7.task3;

import java.io.*;

public class Example1 {
    public static void main(String[] args) {
        try {
            copyFile("src/lr7/task3/input.txt", "src/lr7/task3/output.txt");
            System.out.println("Файл скопирован успешно!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(String sourceFile, String destinationFile) throws IOException {
        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(destinationFile)) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        }
    }
}
