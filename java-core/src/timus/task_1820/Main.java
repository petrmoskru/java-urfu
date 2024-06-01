package timus.task_1820;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int days;
        if (k >= n) {
            days = 2;
        } else {
            days = (2 * n + k - 1) / k;
        }

        System.out.println(days);
    }
}
