package lr3.task8;

public class LinkedList {
    private Node head;
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public void createHead(int data) {
        head = new Node(data, head);
    }
    public void createTail(int data) {
        Node newElement = new Node(data, null);
        if (head == null) {
            head = newElement;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newElement);
        }
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(String.format("%d ", current.getValue()));
            current = current.getNext();
        }
        return result.toString();
    }
    public void addFirst(int data) {
        createHead(data);
    }
    public void addLast(int data) {
        createTail(data);
    }
    public void insert(int data, int index) {
        Node newElement = new Node(data, null);
        if (head == null) {
            createHead(data);
        } else {
            Node current = head;
            int k = 1;
            while (current.getNext() != null && (k < index)) {
                current = current.getNext();
                k++;
            }
            newElement.setNext(current.getNext());
            current.setNext(newElement);
        }
    }
    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }
    public void removeLast() {
        if (head == null || head.getNext() == null) {
            head = null;
        } else {
            Node current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
    }
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            int k = 1;
            while (current.getNext() != null && (k < index)) {
                current = current.getNext();
                k++;
            }
            current.setNext(current.getNext().getNext());
        }
    }
    public void createHeadRec(int data) {
        head = createHeadRecHelper(head, data);
    }
    private Node createHeadRecHelper(Node node, int data) {
        if (node == null) {
            return new Node(data, null);
        }
        node.setNext(createHeadRecHelper(node.getNext(), data));
        return node;
    }
    public void createTailRec(int data) {
        head = createTailRecHelper(head, data);
    }
    private Node createTailRecHelper(Node node, int data) {
        if (node == null) {
            return new Node(data, null);
        }
        node.setNext(createTailRecHelper(node.getNext(), data));
        return node;
    }
    public String toStringRec() {
        return toStringRecHelper(head);
    }
    private String toStringRecHelper(Node node) {
        if (node == null) {
            return "";
        }
        return String.format("%d %s", node.getValue(), toStringRecHelper(node.getNext()));
    }
}
