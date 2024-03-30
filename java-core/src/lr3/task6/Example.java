package lr3.task6;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class Example {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество человек: ");
        int N = in.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
            list1.add(i);
        }
        int index = 0;
        long start = System.nanoTime();
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        long end = System.nanoTime();
        System.out.printf("Остался человек под номером: %d%n", list.get(0));
        System.out.printf("Время ArrayList в нс: %d%n", (end - start));
        Iterator<Integer> iterator = list1.iterator();
        long start1 = System.nanoTime();
        while (list1.size() > 1) {
            if (!iterator.hasNext()) {
                iterator = list1.iterator();
            }
            iterator.next();
            iterator.remove();
        }
        long end1 = System.nanoTime();
        System.out.printf("Остался человек с номером: %d%n", list1.get(0));
        System.out.printf("Время LinkedList в нс: %d%n", (end1 - start1));
    }
}
