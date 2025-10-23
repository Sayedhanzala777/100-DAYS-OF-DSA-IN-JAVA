// Day - 10 : Sorting Algorithms (Part 1)

public class Day10_SortingAlgorithms {

    // Activity 1 : Bubble Sort
    // Task1 > Write a Java program to implement Bubble Sort.
    // Task2 > Print the array before and after sorting.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Activity 2 : Selection Sort
    // Task3 > Implement Selection Sort algorithm.
    // Task4 > Print each pass of the sorting process to visualize how the algorithm works.
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.print("After pass " + (i + 1) + ": ");
            printArray(arr);
        }
    }

    // Activity 3 : Insertion Sort
    // Task5 > Write a Java program for Insertion Sort.
    // Task6 > Print the array after each insertion step.
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.print("After inserting " + key + ": ");
            printArray(arr);
        }
    }

    // Activity 4 : Sorting Strings
    // Task7 > Implement a method to sort an array of strings alphabetically using Bubble Sort logic.
    public static void sortStrings(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Activity 5 : Sorting in Descending Order
    // Task8 > Modify one of the above sorting algorithms to sort numbers in descending order.
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Utility function to print arrays
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Utility function to print string arrays
    public static void printStringArray(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // Main Method to Test All Activities
    public static void main(String[] args) {

        // Bubble Sort
        int[] nums1 = { 5, 1, 4, 2, 8 };
        System.out.print("Original Array (Bubble Sort): ");
        printArray(nums1);
        bubbleSort(nums1);
        System.out.print("Sorted Array: ");
        printArray(nums1);

        // Selection Sort
        int[] nums2 = { 64, 25, 12, 22, 11 };
        System.out.print("\nOriginal Array (Selection Sort): ");
        printArray(nums2);
        selectionSort(nums2);
        System.out.print("Final Sorted Array: ");
        printArray(nums2);

        // Insertion Sort
        int[] nums3 = { 9, 5, 1, 4, 3 };
        System.out.print("\nOriginal Array (Insertion Sort): ");
        printArray(nums3);
        insertionSort(nums3);

        // Sorting Strings
        String[] fruits = { "Mango", "Apple", "Banana", "Orange" };
        System.out.print("\nOriginal String Array: ");
        printStringArray(fruits);
        sortStrings(fruits);
        System.out.print("Alphabetically Sorted: ");
        printStringArray(fruits);

        // Descending Order Sort
        int[] nums4 = { 10, 3, 6, 1, 8 };
        System.out.print("\nOriginal Array (Descending Sort): ");
        printArray(nums4);
        bubbleSortDescending(nums4);
        System.out.print("Sorted in Descending Order: ");
        printArray(nums4);
    }
}
