package lr2;

import java.util.Random;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.println("Введите количество столбцов: ");
        int cols = scanner.nextInt();
        int[][] nums = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    nums[i][j] = random.nextInt(200);
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    nums[i][j] = random.nextInt(200);
                }
            }
        }
        System.out.println("Итоговый массив: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%d\t", nums[i][j]);
            }
            System.out.println();
        }
    }
}
