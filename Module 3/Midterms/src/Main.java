import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Optional: ANSI colors (works in most IDE terminals)
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String MAGENTA = "\u001B[35m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        CardStack deck = new CardStack();
        CardStack discardPile = new CardStack();
        ArrayList<Card> hand = new ArrayList<>();

        // Build deck of 30 cards
        for (int i = 1; i <= 30; i++) {
            deck.push(new Card("Card " + i));
        }

        System.out.println(CYAN + "══════════════════════════════════════");
        System.out.println("        CARD GAME SIMULATION");
        System.out.println("══════════════════════════════════════" + RESET);
        System.out.println("Press ENTER to begin...");
        scanner.nextLine();

        int round = 1;

        // Game loop
        while (!deck.isEmpty()) {

            System.out.println(CYAN + "\n════════════ ROUND " + round + " ════════════" + RESET);

            // Player must press enter to continue
            System.out.print("Press ENTER to continue (or 'q' to quit): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting simulation. Goodbye!");
                break;
            }

            // Generate random command
            int command = rand.nextInt(3) + 1; // 1–3
            int x = rand.nextInt(5) + 1;       // 1–5

            // Pretty command message
            System.out.println(YELLOW + "► Command " + command + " | x = " + x + RESET);

            switch (command) {

                case 1: // DRAW X cards
                    System.out.println(GREEN + "Drawing " + x + " cards..." + RESET);
                    for (int i = 0; i < x; i++) {
                        if (deck.isEmpty()) break;
                        Card drawn = deck.pop();
                        System.out.println("   + " + drawn);
                        hand.add(drawn);
                    }
                    break;

                case 2: // DISCARD X cards
                    System.out.println(MAGENTA + "Discarding " + x + " cards..." + RESET);
                    for (int i = 0; i < x; i++) {
                        if (hand.isEmpty()) break;
                        Card removed = hand.remove(hand.size() - 1);
                        System.out.println("   - " + removed);
                        discardPile.push(removed);
                    }
                    break;

                case 3: // GET X cards from discard
                    System.out.println(GREEN + "Retrieving " + x + " cards from discard..." + RESET);
                    for (int i = 0; i < x; i++) {
                        if (discardPile.isEmpty()) break;
                        Card recovered = discardPile.pop();
                        System.out.println("   ↺ " + recovered);
                        hand.add(recovered);
                    }
                    break;
            }

            // Print pretty summary
            System.out.println(CYAN + "\n╔══════════ ROUND " + round + " SUMMARY ══════════╗" + RESET);
            System.out.println("║  Hand: " + formatHand(hand));
            System.out.println("║  Deck remaining: " + deck.size());
            System.out.println("║  Discard pile: " + discardPile.size());
            System.out.println(CYAN + "╚══════════════════════════════════════╝" + RESET);

            round++;
        }

        // Game ends
        if (deck.isEmpty()) {
            System.out.println(YELLOW + "\n🌟 GAME OVER — The deck is empty! 🌟" + RESET);
        }
    }

    // Formats hand as: Card 30, Card 29, Card 28
    private static String formatHand(ArrayList<Card> hand) {
        if (hand.isEmpty()) return "Empty";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hand.size(); i++) {
            sb.append(hand.get(i));
            if (i < hand.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
