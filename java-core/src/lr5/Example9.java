package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example9 {
    public static void main(String[] args) {
        List<String> strings = List.of("python", "java", "javascript", "golang", "c", "c++", "ruby", "c#");
        System.out.println("Список до: " + strings);
        List<String> filteredStrings = filterStrings(strings);
        System.out.println("Список после: " + filteredStrings);
    }

    public static List<String> filterStrings(List<String> strings) {
        List<String> resultList = new ArrayList<>();
        for (String str : strings) {
            if (str.matches("[a-zA-Z]+")) {
                resultList.add(str);
            }
        }
        return resultList;
    }
}
