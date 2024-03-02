package lr1;

import java.util.Scanner;
import java.time.LocalDate;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();
        int currentYear = LocalDate.now().getYear();
        int yearOfBirth = currentYear - age;
        System.out.println("Ваш год рождения: " + yearOfBirth);
        scanner.close();
    }
}
