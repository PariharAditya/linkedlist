public class LinkedImplementation {
    public static void main(String[] args) {
        Linkedclass lc = new Linkedclass();
        lc.insertFirst(5);
        lc.insertFirst(50);
        lc.insertFirst(5050);
        lc.insertFirst(100);
        lc.tail(1000);
        // at index 2, insert 500
        // lc.atIndex(500, 2);
        // lc.display();
        // System.out.println(lc.search(50));
        // System.out.println(lc.deletionStart() + " is Removed");
        // System.out.println(lc.deletionEnd());
        // System.out.println(lc.deletionIth(2));
        // lc.display();
        lc.display();
        lc.recursiveInserting(1, 99);
        lc.display();


        // DoublyLinked dll = new DoublyLinked();
        // dll.insertHead(1);
        // dll.insertHead(2);
        // dll.insertHead(5);
        // dll.insertHead(15);
        // dll.insertionLast(19);
        // dll.afterIthvalue(5, 0);
        // dll.display();

        // CircularLinkedList cll = new CircularLinkedList();
        // cll.insert(0);
        // cll.insert(2);
        // cll.insert(4);
        // cll.insert(8);

        // cll.display();

    }    
}