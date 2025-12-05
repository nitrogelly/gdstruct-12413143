public class Main {
    public static void main(String[] args) {

        Player blue = new Player(1, "Blueful", 100);
        Player wardell = new Player(2, "TSMWardell", 500);
        Player jimmy = new Player(3, "DeadlyJimmy", 350);

        SimpleHashTable table = new SimpleHashTable();

        table.put(blue.getUsername(), blue);
        table.put(wardell.getUsername(), wardell);
        table.put(jimmy.getUsername(), jimmy);

        System.out.println("-- Before removal --");
        table.printHashTable();

        System.out.println("\nRemoving TSMWardell...");
        table.remove("TSMWardell");

        System.out.println("\n-- After removal --");
        table.printHashTable();
    }
}
