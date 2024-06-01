package timus.task_2035;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int c = in.nextInt();
        if (x + y >= c) {
            if (c < x || c < y) {
                if (x - c > 0) {
                    System.out.println(c + " " + 0);
                } else {
                    System.out.println(0 + " " + c);
                }
            } else if (c - x > 0) {
                System.out.println(x + " " + (c - x));
            } else {
                System.out.println(x + " " + (c - y));
            }
        } else {
            System.out.println("Impossible");
        }
    }
}
