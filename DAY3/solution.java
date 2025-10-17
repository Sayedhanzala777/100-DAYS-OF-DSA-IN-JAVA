import java.util.*;

public class CheckSorted {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        boolean sorted = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }

        System.out.println(sorted ? "Sorted" : "Not Sorted");
    }
}
