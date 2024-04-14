package lr4.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным числом");
            }
            byte[] array = new byte[size];
            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < size; i++) {
                try {
                    array[i] = scanner.nextByte();
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Введите целое число типа byte.");
                    return;
                }
            }
            int sum = 0;
            for (byte value : array) {
                try {
                    sum = Math.addExact(sum, value);
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка вычисления суммы. Превышено значение диапазона типа byte.");
                    return;
                }
            }
            System.out.println("Сумма элементов массива: " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Введите целое число.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
