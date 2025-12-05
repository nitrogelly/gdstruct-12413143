public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        System.out.println("Ascending traversal:");
        tree.traverseInOrder();
        System.out.println("\n");

        System.out.println("Descending traversal:");
        tree.traverseInOrderDescending();
        System.out.println("\n");

        System.out.println("Min value in the tree: " + tree.getMin().getValue());
        System.out.println("Max value in the tree: " + tree.getMax().getValue());
    }
}
