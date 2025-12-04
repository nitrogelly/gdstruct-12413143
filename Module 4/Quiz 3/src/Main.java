import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        ArrayQueue queue = new ArrayQueue(50);

        int nextPlayerID = 1;
        int gamesPlayed = 0;

        System.out.println("=== Matchmaking Simulator ===");
        System.out.println("Press ENTER to start...");
        scanner.nextLine();

        while (gamesPlayed < 10) {

            System.out.println("\n---- NEW TURN ----");
            System.out.print("Press ENTER to continue...");
            scanner.nextLine();

            // 1. x players join the queue
            int x = rand.nextInt(7) + 1; // 1–7
            System.out.println(x + " players joining matchmaking...");

            for (int i = 0; i < x; i++) {
                queue.add(new Player(nextPlayerID++));
            }

            System.out.println("Current queue size: " + queue.size());

            // 2. Start a game if at least 5 players in queue
            if (queue.size() >= 5) {
                System.out.println(">>> Starting a game!");

                System.out.print("Matched players: ");

                // 3. Pop 5 players (FIFO)
                for (int j = 0; j < 5; j++) {
                    Player matched = queue.remove();
                    System.out.print(matched + "  ");
                }

                System.out.println();

                gamesPlayed++;

                System.out.println("Games completed: " + gamesPlayed + "/10");
            }
        }

        System.out.println("\n=== All 10 games completed! Program ending. ===");
    }
}
