package timus.task_1910;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                System.getProperty("ONLINE_JUDGE") != null ?
                        new InputStreamReader(System.in) :
                        new FileReader("src/timus/task_1910/input.txt")
        );
        PrintWriter out = new PrintWriter(System.out);

        int size = Integer.parseInt(bufferedReader.readLine());
        String[] strings = bufferedReader.readLine().split(" ");

        int[] intsAfter = new int[size - 2];
        for (int i = 0; i < size - 2; i++) {
            intsAfter[i] = Integer.parseInt(strings[i]) +
                    Integer.parseInt(strings[i + 1]) +
                    Integer.parseInt(strings[i + 2]);
        }

        int maxSum = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < intsAfter.length; i++) {
            if (intsAfter[i] > maxSum) {
                maxSum = intsAfter[i];
                index = i + 2;
            }
        }

        out.println(maxSum + " " + index);
        out.flush();
    }
}
