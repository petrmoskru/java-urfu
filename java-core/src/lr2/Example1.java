package lr2;

import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер списка: ");
        int size = scanner.nextInt();
        System.out.printf("Размер списка: %d%n", size);
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(200);
            System.out.printf("Элемент [%d] = %d%n", i, numbers[i]);
        }
        System.out.println("Начинается поиск минимума");
        int minimum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minimum) {
                minimum = numbers[i];
            }
        }
        System.out.printf("Поиск минимума завершен.%nМинимальное значение: %d%n", minimum);
        System.out.println("Поиск всех минимальных значений");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == minimum) {
                System.out.printf("Индекс минимального элемента: %d%n", i);
                System.out.printf("Значение минимального элемента: %d%n", numbers[i]);
            }
        }
    }
}