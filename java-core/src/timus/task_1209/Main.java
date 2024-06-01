package timus.task_1209;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long x = in.nextLong() - 1;
            long y = (long) Math.sqrt(8 * x + 1);
            System.out.println((y * y == 8 * x + 1) ? "1" : "0");
        }
    }
}
