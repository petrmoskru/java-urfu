package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example5 {
    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        inputList.add("python");
        inputList.add("java");
        inputList.add("javascript");
        inputList.add("golang");
        inputList.add("c");
        inputList.add("c++");
        inputList.add("ruby");
        inputList.add("c#");
        System.out.println("Список до: " + inputList);
        List<String> filteredList = filterStrings(inputList, "a");
        System.out.println("Список после: " + filteredList);
    }
    public static List<String> filterStrings(List<String> list, String substring) {
        List<String> resultList = new ArrayList<>();
        for (String str : list) {
            if (str.contains(substring)) {
                resultList.add(str);
            }
        }
        return resultList;
    }
}
