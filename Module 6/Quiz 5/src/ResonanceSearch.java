public class ResonanceSearch {

    public static int search(int[] array, int target) {

        // Phase 1: search indices that are multiples of 3
        for (int i = 0; i < array.length; i++) {
            if (i % 3 == 0 && array[i] == target) {
                return i;
            }
        }

        // Phase 2: search prime indices
        for (int i = 2; i < array.length; i++) {
            if (isPrime(i) && array[i] == target) {
                return i;
            }
        }

        // Phase 3: search remaining indices
        for (int i = 0; i < array.length; i++) {
            if (i % 3 != 0 && !isPrime(i) && array[i] == target) {
                return i;
            }
        }

        return -1;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
