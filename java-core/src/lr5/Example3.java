package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        String string = "Напишите функцию, Которая принимает на вход список" +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые Начинаются с большой буквы.";
        List<String> strings = List.of(string.split(" "));
        List<String> stringsAfter = filterCapitalizedStrings(strings);
        System.out.println("\nСтроки с заглавными буквами: ");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }
    public static List<String> filterCapitalizedStrings(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (String str : list) {
            if (!str.isEmpty() && Character.isUpperCase(str.charAt(0))) {
                resultList.add(str);
            }
        }
        return resultList;
    }
}
