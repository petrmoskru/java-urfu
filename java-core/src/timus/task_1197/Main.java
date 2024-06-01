package timus.task_1197;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int q = 0; q < test; q++) {
            String position = in.next();
            char x1 = position.charAt(0);
            char y1 = position.charAt(1);
            int x = x1 - 'a' + 1;
            int y = y1 - '1' + 1;

            int bingo = countBingo(x, y);
            out.println(bingo);
        }
        out.flush();
    }
    private static int countBingo(int x, int y) {
        int bingo = 0;
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) != Math.abs(j) && isValidPosition(x - i, y - j)) {
                    if (i * i + j * j == 5) {
                        bingo++;
                    }
                }
            }
        }
        return bingo;
    }
    private static boolean isValidPosition(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }
}
