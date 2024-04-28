package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example7 {
    public static void main(String[] args) {
        List<String> inputList = List.of("python", "java", "javascript", "golang", "c", "c++", "ruby", "c#");
        System.out.println("Список до: " + inputList);
        List<String> filteredList = filterStringsByLength(inputList, 5);
        System.out.println("Список после: " + filteredList);
    }
    public static List<String> filterStringsByLength(List<String> list, int minLength) {
        List<String> resultList = new ArrayList<>();
        for (String str : list) {
            if (str.length() > minLength) {
                resultList.add(str);
            }
        }
        return resultList;
    }
}
