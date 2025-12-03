public class Main {

    // Print elements using the classic for-loop style used in lecture
    private static void printArrayElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Bubble sort in professor's style (using lastSortedIndex, no swapped flag)
    // This version sorts in DESCENDING order (quiz requirement)
    private static void bubbleSortDescending(int[] array) {
        int lastSortedIndex = array.length - 1;

        while (lastSortedIndex > 0) {
            for (int i = 0; i < lastSortedIndex; i++) {
                if (array[i] < array[i + 1]) { // flipped comparison for descending
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            lastSortedIndex = lastSortedIndex - 1;
        }
    }

    // Selection sort in professor's style (normal): finds largest and puts at end
    // (kept here for comparison / testing)
    private static void selectionSortFindLargestToEnd(int[] array) {
        for (int last = array.length - 1; last > 0; last--) {
            int largestIndex = 0;
            for (int i = 1; i <= last; i++) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }
            int temp = array[last];
            array[last] = array[largestIndex];
            array[largestIndex] = temp;
        }
    }

    // Selection sort quiz variant: find the SMALLEST and put it at the END
    // (implements the exact twist requested by the quiz)
    private static void selectionSortSmallestToEnd(int[] array) {
        int lastSortedIndex = array.length - 1;

        while (lastSortedIndex > 0) {
            int smallestIndex = 0;

            for (int i = 1; i <= lastSortedIndex; i++) {
                if (array[i] < array[smallestIndex]) {
                    smallestIndex = i;
                }
            }

            // swap smallest into the lastSortedIndex
            int temp = array[lastSortedIndex];
            array[lastSortedIndex] = array[smallestIndex];
            array[smallestIndex] = temp;

            lastSortedIndex = lastSortedIndex - 1;
        }
    }

    public static void main(String[] args) {
        // Example array similar to lecture (unsorted)
        int[] numbers = {25, -3, 5, 10, 38, 62, 20, -8, 173, 65};

        System.out.println("Original:");
        printArrayElements(numbers);

        // Bubble Sort (descending) - quiz requirement
        int[] bubbleArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            bubbleArr[i] = numbers[i];
        }
        bubbleSortDescending(bubbleArr);
        System.out.println("After Bubble Sort (Descending):");
        printArrayElements(bubbleArr);

        // Selection Sort (smallest -> end) - quiz variant
        int[] selectArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            selectArr[i] = numbers[i];
        }
        selectionSortSmallestToEnd(selectArr);
        System.out.println("After Selection Sort (Smallest -> End):");
        printArrayElements(selectArr);

        // (Optional) Professor-style selection sort for reference
        int[] selectionReference = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            selectionReference[i] = numbers[i];
        }
        selectionSortFindLargestToEnd(selectionReference);
        System.out.println("After Selection Sort (Find Largest -> End) [reference]:");
        printArrayElements(selectionReference);
    }
}
