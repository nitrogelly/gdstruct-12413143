public class Player {
    private int id;

    public Player(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Player " + id;
    }
}
