// Day 5 : Searching Algorithms

import java.util.*;

public class SearchingAlgorithms {

    // Activity 1 : Linear Search
    // Task 1 & 2: Find index of an element using linear search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // Activity 2 : Binary Search
    // Task 3 & 4: Find index of an element using binary search (array must be sorted)
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Activity 3 : Practice Problems
    // Task 5 : Find all occurrences of a given element
    public static List<Integer> findAllOccurrences(int[] arr, int key) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) indices.add(i);
        }
        return indices;
    }

    // Task 6 : Check if number exists in a sorted array using binary search
    public static boolean existsInSorted(int[] arr, int key) {
        return binarySearch(arr, key) != -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 8, 2};

        // Linear Search
        int key1 = 8;
        int index1 = linearSearch(arr, key1);
        System.out.println("Linear Search: " + key1 + " found at index " + index1);

        // Binary Search (array must be sorted)
        int[] sortedArr = {1, 2, 3, 5, 8};
        int key2 = 5;
        int index2 = binarySearch(sortedArr, key2);
        System.out.println("Binary Search: " + key2 + " found at index " + index2);

        // Find all occurrences
        int[] arr2 = {1, 5, 3, 5, 7, 5};
        int key3 = 5;
        System.out.println("All occurrences of " + key3 + ": " + findAllOccurrences(arr2, key3));

        // Check existence in sorted array
        int key4 = 4;
        System.out.println("Exists in sorted array? " + existsInSorted(sortedArr, key4));
    }
}
