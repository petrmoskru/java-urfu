package lr3.task7;

public class Example {
    public static void main(String[] args) {
        System.out.println("Список, начиная с головы:");
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        Node ref = node0;
        while (ref != null) {
            System.out.printf(" %d%n", ref.getValue());
            ref = ref.getNext();
        }
        System.out.println("Список, начиная с хвоста:");
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }
        ref = head;
        while (ref != null) {
            System.out.printf(" %d%n", ref.getValue());
            ref = ref.getNext();
        }
    }
}
