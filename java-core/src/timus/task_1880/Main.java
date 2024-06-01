package timus.task_1880;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                System.getProperty("ONLINE_JUDGE") != null ?
                        new InputStreamReader(System.in) :
                        new FileReader("src/timus/task_1880/input.txt")
        );

        int[] sizes = new int[3];
        String[][] strings = new String[3][];

        for (int i = 0; i < 3; i++) {
            sizes[i] = Integer.parseInt(bufferedReader.readLine());
            strings[i] = bufferedReader.readLine().split(" ");
        }

        int totalCount = sizes[0] + sizes[1] + sizes[2];
        String[] allStrings = new String[totalCount];

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < sizes[i]; j++) {
                allStrings[index++] = strings[i][j];
            }
        }

        Arrays.sort(allStrings);

        int count = 0;
        for (int i = 1; i < totalCount - 1; i++) {
            if (allStrings[i - 1].equals(allStrings[i]) && allStrings[i].equals(allStrings[i + 1])) {
                count++;
            }
        }

        System.out.println(count);
    }
}
