package lr4.task2;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Example1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество элементов в массиве: ");
            int size = scanner.nextInt();
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным числом");
            }
            int sum = 0;
            int positiveCount = 0;
            for (int i = 0; i < size; i++) {
                System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
                int num = scanner.nextInt();
                if (num > 0) {
                    sum += num;
                    positiveCount++;
                }
            }
            if (positiveCount == 0) {
                throw new NoSuchElementException("Введены только неположительные числа");
            }
            double average = (double) sum / positiveCount;
            System.out.println("Среднее значение положительных элементов: " + average);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Введите целое число.");
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
