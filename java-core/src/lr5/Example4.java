package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Example4 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        System.out.println("\nСписок до: ");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            System.out.println(integers.get(i));
        }
        List<Integer> integersAfter = squareList(integers);
        System.out.println("\nСписок после возведения в квадрат: ");
        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }
    public static List<Integer> squareList(List<Integer> list) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer num : list) {
            resultList.add(num * num);
        }
        return resultList;
    }
}
