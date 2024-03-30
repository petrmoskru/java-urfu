package lr3;

import java.util.*;

public class task9 {
    public static void main(String[] args) {
        int number = 16;
        List<Integer> arrayList = new ArrayList<>();
        SortedSet<Integer> sortedSet = new TreeSet<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        addElements(arrayList, number);
        addElements(sortedSet, number);
        addElements(linkedHashMap, number);

        System.out.println("Время в наносекундах");
        System.out.println("Время выполнения операции добавления в начало ArrayList = " + measureAddTime(arrayList, 0, 100));
        System.out.println("Время выполнения операции добавления в середину ArrayList = " + measureAddTime(arrayList, (arrayList.size() / 2), 500));
        System.out.println("Время выполнения операции добавления в конец ArrayList = " + measureAddTime(arrayList, arrayList.size(), 500));

        System.out.println("Время выполнения операции добавления в начало sortedSet = " + measureAddTime(sortedSet, 0));
        System.out.println("Время выполнения операции добавления в середину sortedSet = " + measureAddTime(sortedSet, (sortedSet.size() / 2)));
        System.out.println("Время выполнения операции добавления в конец sortedSet = " + measureAddTime(sortedSet, sortedSet.size()));

        System.out.println("Время выполнения операции добавления в начало LinkedHashMap = " + measureAddTime(linkedHashMap, 0, 100));
        System.out.println("Время выполнения операции добавления в середину LinkedHashMap = " + measureAddTime(linkedHashMap, (linkedHashMap.size() / 2), 500));
        System.out.println("Время выполнения операции добавления в конец LinkedHashMap = " + measureAddTime(linkedHashMap, linkedHashMap.size(), 500));

        System.out.println("Время выполнения операции удаления в начале ArrayList = " + measureRemoveTime(arrayList, 0));
        System.out.println("Время выполнения операции удаления в середине ArrayList = " + measureRemoveTime(arrayList, (arrayList.size() / 2)));
        System.out.println("Время выполнения операции удаления в конце ArrayList = " + measureRemoveTime(arrayList, arrayList.size() - 1));

        System.out.println("Время выполнения операции удаления в начале sortedSet = " + measureRemoveTime(sortedSet, sortedSet.first()));
        System.out.println("Время выполнения операции удаления в середине sortedSet = " + measureRemoveTime(sortedSet, sortedSet.toArray(new Integer[0])[sortedSet.size() / 2]));
        System.out.println("Время выполнения операции удаления в конце sortedSet = " + measureRemoveTime(sortedSet, sortedSet.last()));

        System.out.println("Время выполнения операции удаления в начале LinkedHashMap = " + measureRemoveTime(linkedHashMap, linkedHashMap.keySet().iterator().next()));
        System.out.println("Время выполнения операции удаления в середине LinkedHashMap = " + measureRemoveTime(linkedHashMap, linkedHashMap.keySet().toArray(new Integer[0])[linkedHashMap.size() / 2]));
        System.out.println("Время выполнения операции удаления в конце LinkedHashMap = " + measureRemoveTime(linkedHashMap, linkedHashMap.keySet().toArray(new Integer[0])[linkedHashMap.size() - 1]));

        System.out.println("Время выполнения операции взятия элемента ArrayList = " + measureGetTime(arrayList, 267));
        System.out.println("Время выполнения операции взятия элемента sortedSet = " + measureGetTime(sortedSet, 267));
        System.out.println("Время выполнения операции взятия элемента LinkedHashMap = " + measureGetTime(linkedHashMap, 267));
    }

    private static void addElements(List<Integer> list, int number) {
        for (int i = 0; i < 1_000_000 * number; i++) {
            list.add(i);
        }
    }

    private static void addElements(SortedSet<Integer> set, int number) {
        for (int i = 0; i < 1_000_000 * number; i++) {
            set.add(i);
        }
    }

    private static void addElements(Map<Integer, Integer> map, int number) {
        for (int i = 0; i < 1_000_000 * number; i++) {
            map.put(i, i);
        }
    }

    private static long measureAddTime(List<Integer> list, int index, int value) {
        long start = System.nanoTime();
        list.add(index, value);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureAddTime(SortedSet<Integer> set, int value) {
        long start = System.nanoTime();
        set.add(value);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureAddTime(Map<Integer, Integer> map, int key, int value) {
        long start = System.nanoTime();
        map.put(key, value);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureRemoveTime(List<Integer> list, int index) {
        long start = System.nanoTime();
        list.remove(index);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureRemoveTime(SortedSet<Integer> set, int element) {
        long start = System.nanoTime();
        set.remove(element);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureRemoveTime(Map<Integer, Integer> map, int key) {
        long start = System.nanoTime();
        map.remove(key);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureGetTime(List<Integer> list, int index) {
        long start = System.nanoTime();
        int k = list.get(index);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureGetTime(SortedSet<Integer> set, int element) {
        long start = System.nanoTime();
        set.contains(element);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureGetTime(Map<Integer, Integer> map, int key) {
        long start = System.nanoTime();
        map.get(key);
        long end = System.nanoTime();
        return end - start;
    }
}

