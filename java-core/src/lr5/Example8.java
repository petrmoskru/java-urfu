package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example8 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        System.out.println("Список до: " + numbers);
        int threshold = 50;
        List<Integer> filteredNumbers = filterNumbers(numbers, threshold);
        System.out.println("Список после: " + filteredNumbers);
    }
    public static List<Integer> filterNumbers(List<Integer> numbers, int threshold) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer number : numbers) {
            if (number > threshold) {
                resultList.add(number);
            }
        }
        return resultList;
    }
}
