package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example6 {
    public static void main(String[] args) {
        List<Integer> inputList = List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        System.out.println("Список до: " + inputList);
        List<Integer> filteredList = filterDivisibleNumbers(inputList, 3);
        System.out.println("Список после: " + filteredList);
    }
    public static List<Integer> filterDivisibleNumbers(List<Integer> list, int divisor) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer num : list) {
            if (num % divisor == 0) {
                resultList.add(num);
            }
        }
        return resultList;
    }
}
