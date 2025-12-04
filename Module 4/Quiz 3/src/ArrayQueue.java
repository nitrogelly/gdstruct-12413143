import java.util.NoSuchElementException;

public class ArrayQueue {

    private Player[] q;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        q = new Player[capacity];
        front = 0;
        back = 0;
    }

    public void add(Player player) {
        // Resize if full
        if (back == q.length) {
            Player[] newArray = new Player[q.length * 2];
            System.arraycopy(q, 0, newArray, 0, q.length);
            q = newArray;
        }

        q[back] = player;
        back++;
    }

    public Player remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Player removed = q[front];
        q[front] = null;
        front++;

        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return removed;
    }

    public Player peek() {
        if (size() == 0) throw new NoSuchElementException();
        return q[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        System.out.println("Queue:");
        for (int i = front; i < back; i++) {
            System.out.println(q[i]);
        }
    }
}
