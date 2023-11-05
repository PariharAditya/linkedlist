public class Linkedclass {

    private Node head;
    private Node tail;
    private int size;

    public Linkedclass() {
        this.size = 0;
    }

    /* Node creation and updating */
    public void insertFirst(int val) {
        // creating a new node and assigning it to head
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    /* Node @ end */
    public void tail(int val) {
        // creating a new node and assigning it to tail
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        node.next = node;
        tail = node;

        size += 1;
    }

    /* inserting @ i'th position */
    public void atIndex(int val, int position) {
        if (position == 0) {
            insertFirst(val);
            return;
        }
        if (position == size) {
            insertFirst(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next); // the new node is getting added and the next node is getting assigned to
                                              // the new node
        temp.next = node;
        size++;

    }

    // Deletion @ start
    public int deletionStart() {
        int val = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    // Deletion @ end
    public int deletionEnd() {
        if (size <= 1) {
            return deletionStart();
        }
        Node secondLast = get(size - 2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;

        return val;
    }

    // Deletion at i'th index
    public int deletionIth(int index) {
        if (index == 0) {
            return deletionStart();
        }

        if (index == size - 1) {
            return deletionEnd();
        }

        Node prev = get(index - 1);
        int val = prev.next.data;

        prev.next = prev.next.next;

        return val;
    }

    public Node search(int val) {
        Node node = head;

        while (node.next != null) {
            if (node.data == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //Recursive insertion
    public void recursiveInserting(int index, int val) {
        head = recursiveInserting(index, val, head);
    }


    public Node recursiveInserting(int index, int val, Node currentNode) {
        if (index == 0) {
            Node temp = new Node(val, currentNode);
            size++;
            return temp;
        }
        currentNode.next = recursiveInserting(index-1, val, currentNode.next);
        return currentNode;       
    }

    /* Display function */
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("end");
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

    }

}