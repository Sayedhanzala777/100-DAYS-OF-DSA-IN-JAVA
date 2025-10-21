public class Day7 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};

        int max = arr[0];
        int min = arr[0];

        // Traverse the array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
