package lr3.task8;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.createHead(5);
        list.createHead(4);
        list.createHead(3);
        list.createHead(2);
        list.createHead(1);
        System.out.println("Список: " + list);
        list.addLast(4);
        System.out.println("Список после добавления элемента в конец: " + list);
        list.insert(5, 2);
        System.out.println("Список после добавления элемента в индекс 2: " + list);
        list.removeFirst();
        System.out.println("Список после удаления первого элемента: " + list);
        list.removeLast();
        System.out.println("Список после удаления последнего элемента: " + list);
        list.remove(1);
        System.out.println("Список после удаления элемента с индексом 1: " + list);
        list.createHeadRec(5);
        System.out.println("Список после добавления элемента через рекурсию с головы: " + list);
        list.createTailRec(6);
        System.out.println("Список после добавления элемента через рекурсию с хвоста: " + list);
    }
}
