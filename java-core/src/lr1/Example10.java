package lr1;

import java.util.Calendar;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.print("Введите год вашего рождения: ");
        int birthYear = scanner.nextInt();
        int age = currentYear - birthYear;
        System.out.println("Ваш возраст: " + age + " лет");
        scanner.close();
    }
}