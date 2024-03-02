package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int inputNumber = scanner.nextInt();
        int prevNumber = inputNumber - 1;
        int nextNumber = inputNumber + 1;
        int squareSum = inputNumber * inputNumber + prevNumber + inputNumber + nextNumber;
        System.out.println("Последовательность из четырех чисел:");
        System.out.println(prevNumber);
        System.out.println(inputNumber);
        System.out.println(nextNumber);
        System.out.println("Четвертое число (квадрат суммы первых трех чисел): " + squareSum);
        scanner.close();
    }
}