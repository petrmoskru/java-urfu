package lr3.task5;

import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Ноль");
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");
        map.put(4, "Четыре");
        map.put(5, "Пять");
        map.put(6, "Шесть");
        map.put(7, "Семь");
        map.put(8, "Восемь");
        map.put(9, "Девять");
        map.put(10, "Десять");
        String result = "";
        int product = 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            if (key > 5) {
                System.out.println(value);
            } else if (key == 0) {
                StringBuilder sb = new StringBuilder();
                for (String str : map.values()) {
                    sb.append(str).append(", ");
                }
                result = sb.substring(0, sb.length() - 2);
            }
            if (value != null && value.length() > 5) {
                product *= key;
            }
        }
        System.out.printf("Результат: %s%n", result);
        System.out.printf("Произведение ключей с длиной строки больше 5: %d%n", product);
    }
}
