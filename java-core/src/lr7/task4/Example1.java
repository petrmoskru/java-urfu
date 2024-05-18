package lr7.task4;

import java.io.File;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();
        String filePath = "src/lr7/task4/" + fileName + ".txt";
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            long fileSize = file.length();
            System.out.println("Размер файла " + fileName + " составляет " + fileSize + " байт.");
        } else {
            System.out.println("Файл не найден.");
        }
        scanner.close();
    }
}
