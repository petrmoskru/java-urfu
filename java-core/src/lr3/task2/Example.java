package lr3.task2;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int decimal = in.nextInt();
        System.out.println("Двоичное представление числа " + decimal + ": ");
        decimalToBinary(decimal);
        in.close();
    }

    public static void decimalToBinary(int n) {
        if (n > 0) {
            decimalToBinary(n / 2);
            System.out.print(n % 2);
        }
    }
}
