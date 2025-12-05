public class Main {
    public static void main(String[] args) {

        int[] data = {5, 8, 21, 3, 13, 8, 34, 7};
        int target = 13;

        int index = ResonanceSearch.search(data, target);

        System.out.println("Found " + target + " at index: " + index);
    }
}
