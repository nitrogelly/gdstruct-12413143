public class Tree {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(value, root);
        }
    }

    private void insert(int value, Node current) {
        if (value < current.getValue()) {
            if (current.getLeftChild() == null) {
                current.setLeftChild(new Node(value));
            } else {
                insert(value, current.getLeftChild());
            }
        } else {
            if (current.getRightChild() == null) {
                current.setRightChild(new Node(value));
            } else {
                insert(value, current.getRightChild());
            }
        }
    }

    // 🚩 QUIZ REQUIREMENT 1
    public Node getMin() {
        if (root == null) return null;

        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    // 🚩 QUIZ REQUIREMENT 2
    public Node getMax() {
        if (root == null) return null;

        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    // Existing ascending order
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            traverseInOrder(node.getRightChild());
        }
    }

    // 🚩 QUIZ REQUIREMENT 3
    public void traverseInOrderDescending() {
        traverseInOrderDescending(root);
    }

    private void traverseInOrderDescending(Node node) {
        if (node != null) {
            traverseInOrderDescending(node.getRightChild());
            System.out.print(node.getValue() + " ");
            traverseInOrderDescending(node.getLeftChild());
        }
    }
}
