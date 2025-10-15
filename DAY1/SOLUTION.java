import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        reverseArray(arr);
        
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
