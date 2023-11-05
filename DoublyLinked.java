public class DoublyLinked {
    private class Node { 
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    //inserting @ head
    public void insertHead(int val) {
        Node node = new Node(val); // creating new node
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    //inserting @ particular index
    public void insertionLast(int val) {
        Node node = new Node(val);
        Node last = head;

        node.next = null;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    //inserting after particular index 
    public void afterIthvalue(int after, int data) {
        Node prev = find(after);

        if (prev == null) {
            System.out.println("not possible");
        }

        Node node = new Node(data);
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    private Node find(int after) {
        Node node = head;
        while (node != null) {
            if (node.data == after) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node node = head;
        Node last = null;

        while (node != null) {
            System.out.print(node.data + "-> ");
            last = node;
            node = node.next;
        }
        System.out.println("End");
        
        System.out.println("Printing in reverse");
        while (last != null) {
            System.out.print(last.data + "-> ");
            last = last.prev;
        }
        System.out.println("Reached start");

    }
}
