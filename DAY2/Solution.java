public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 8, -2, 7};

        int max = findMax(arr);
        int min = findMin(arr);

        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
