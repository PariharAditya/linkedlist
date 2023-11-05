public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    public void insert(int data) {
        Node node = new Node(data);
        
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.data + "-> ");
                node = node.next;
            } while (node != head);
        }
    }
}
