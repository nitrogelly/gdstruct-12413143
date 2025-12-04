public class Main {
    public static void main(String[] args) {

        Player p1 = new Player(1, "Heathcliff", 99);
        Player p2 = new Player(2, "Asuna", 100);
        Player p3 = new Player(3, "LethalBacon", 205);
        Player p4 = new Player(4, "HPDeskjet", 34);

        PlayerLinkedList list = new PlayerLinkedList();

        list.addToFront(p1);
        list.addToFront(p2);
        list.addToFront(p3);
        list.addToFront(p4);

        System.out.println("Singly Linked List:");
        list.printList();

        System.out.println("\nSize: " + list.getSize());

        System.out.println("\nRemoving first element...");
        Player removed = list.removeFromFront();
        System.out.println("Removed: " + removed);

        System.out.println("\nNew list:");
        list.printList();
        System.out.println("New size: " + list.getSize());

        System.out.println("\nContains Asuna? " + list.contains(p2));
        System.out.println("Index of LethalBacon: " + list.indexOf(p3));

        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addToFront(p1);
        dList.addToFront(p2);
        dList.addToFront(p3);

        System.out.println("\nDoubly Linked List:");
        dList.printList();
        System.out.println("Size: " + dList.getSize());
    }
}
