public class PlayerLinkedList {
    private PlayerNode head;
    private int size;

    public void addToFront(Player player) {
        PlayerNode node = new PlayerNode(player);
        node.setNext(head);
        head = node;
        size++;
    }

    public Player removeFromFront() {
        if (head == null) {
            return null;
        }

        PlayerNode removedNode = head;
        head = removedNode.getNext();
        removedNode.setNext(null);
        size--;

        return removedNode.getPlayer();
    }

    public int getSize() {
        return size;
    }

    public boolean contains(Player player) {
        PlayerNode current = head;

        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;

        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    public void printList() {
        PlayerNode current = head;

        while (current != null) {
            System.out.println(current.getPlayer());
            current = current.getNext();
        }
    }
}
