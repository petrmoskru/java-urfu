package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example10 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);
        numbers.add(80);
        numbers.add(90);
        numbers.add(100);
        System.out.println("Список до: " + numbers);
        int threshold = 50;
        List<Integer> filteredNumbers = filterNumbers(numbers, threshold);
        System.out.println("Список после: " + filteredNumbers);
    }
    public static List<Integer> filterNumbers(List<Integer> numbers, int threshold) {
        List<Integer> filteredNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (num < threshold) {
                filteredNumbers.add(num);
            }
        }
        return filteredNumbers;
    }
}
