package lr7.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example1 {
    public static void main(String[] args) {
        String fileName = "src/lr7/task2/input.txt";
        int lineCount = countLines(fileName);
        System.out.println("Количество строк в файле: " + lineCount);
    }

    private static int countLines(String fileName) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}
