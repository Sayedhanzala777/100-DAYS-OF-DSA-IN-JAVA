

// Day - 16 : Searching Algorithms

public class Day16_Searching {

    // Activity 1 : Linear Search
    // Task 1 > Implement Linear Search
    public static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }

    // Task 2 > Implement Linear Search for Strings
    public static int linearSearchString(String[] arr, String target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(target)) return i;
        }
        return -1;
    }

    // Activity 2 : Binary Search
    // Task 3 > Binary Search (Iterative)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Task 4 > Binary Search (Recursive)
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if(left > right) return -1;
        int mid = left + (right - left) / 2;
        if(arr[mid] == target) return mid;
        if(arr[mid] > target) return binarySearchRecursive(arr, target, left, mid - 1);
        return binarySearchRecursive(arr, target, mid + 1, right);
    }

    // Activity 3 : Edge Cases
    // Task 5 > Search in Unsorted Array using Linear Search
    public static int searchUnsorted(int[] arr, int target) {
        return linearSearch(arr, target);
    }

    // Task 6 > Search Element Occurrence Count
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for(int num : arr) {
            if(num == target) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        int[] numbers = {2, 4, 6, 8, 10, 12};
        String[] names = {"Ali", "Sayed", "Hanzala", "Zaid"};

        System.out.println("---- Linear Search ----");
        System.out.println("Found 8 at index: " + linearSearch(numbers, 8));
        System.out.println("Found 'Hanzala' at index: " + linearSearchString(names, "Hanzala"));

        System.out.println("\n---- Binary Search ----");
        System.out.println("Binary Search (Iterative): " + binarySearch(numbers, 10));
        System.out.println("Binary Search (Recursive): " + binarySearchRecursive(numbers, 10, 0, numbers.length - 1));

        System.out.println("\n---- Other Searches ----");
        int[] arr = {5, 2, 8, 2, 4, 2};
        System.out.println("Found 8 at index (unsorted): " + searchUnsorted(arr, 8));
        System.out.println("Occurrences of 2: " + countOccurrences(arr, 2));
    }
}
