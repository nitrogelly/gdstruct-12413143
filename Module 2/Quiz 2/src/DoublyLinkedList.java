public class DoublyLinkedList {
    private DoublyPlayerNode head;
    private int size;

    public void addToFront(Player player) {
        DoublyPlayerNode node = new DoublyPlayerNode(player);
        node.setNext(head);

        if (head != null) {
            head.setPrevious(node);
        }

        head = node;
        size++;
    }

    public void printList() {
        DoublyPlayerNode current = head;

        while (current != null) {
            System.out.println(current.getPlayer());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}
