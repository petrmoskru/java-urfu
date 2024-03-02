package lr1;

import java.util.Scanner;
import java.time.LocalDate;

public class Example11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите ваш год рождения: ");
        int yearOfBirth = scanner.nextInt();
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - yearOfBirth;
        System.out.println("Привет, " + name + "! Ваш возраст: " + age + " лет.");
        scanner.close();
    }
}
