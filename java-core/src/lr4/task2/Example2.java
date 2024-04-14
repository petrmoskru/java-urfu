package lr4.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество строк в матрице: ");
            int rows = scanner.nextInt();
            if (rows <= 0) {
                throw new IllegalArgumentException("Количество строк должно быть положительным числом");
            }
            System.out.print("Введите количество столбцов в матрице: ");
            int cols = scanner.nextInt();
            if (cols <= 0) {
                throw new IllegalArgumentException("Количество столбцов должно быть положительным числом");
            }
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = (int) (Math.random() * 100);
                }
            }
            System.out.print("Введите номер столбца для вывода: ");
            int columnNumber = scanner.nextInt();
            if (columnNumber < 0 || columnNumber >= cols) {
                throw new IllegalArgumentException("Номер столбца должен быть в пределах от 0 до " + (cols - 1));
            }
            System.out.println("Столбец " + columnNumber + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][columnNumber]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Введите целое число.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
