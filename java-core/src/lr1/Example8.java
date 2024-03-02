package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название текущего дня недели: ");
        String dayOfWeek = scanner.nextLine();
        System.out.print("Введите название месяца: ");
        String month = scanner.nextLine();
        System.out.print("Введите номер дня в месяце: ");
        int dayOfMonth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Сегодня " + dayOfWeek + ", " + dayOfMonth + " " + month);
        scanner.close();
    }
}