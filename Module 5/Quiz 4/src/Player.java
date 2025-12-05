public class Player {
    private int id;
    private String username;
    private int level;

    public Player(int id, String username, int level) {
        this.id = id;
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Player { id = " + id + ", username = '" + username + "', level = " + level + " }";
    }
}
