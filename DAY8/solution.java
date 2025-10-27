// Day - 9 : Searching Algorithms

// Activity 1 : Linear Search
// Task 1 > Write a Java function to perform a linear search on an array.
// Task 2 > If the element is found, return its index; otherwise, return -1.

public class Day9_SearchingAlgorithms {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Activity 2 : Binary Search
    // Task 3 > Write a Java function to perform a binary search on a sorted array.
    // Task 4 > Return the index of the target element if found; otherwise, return -1.
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    // Activity 3 : Searching Strings
    // Task 5 > Implement a function that checks whether a given string exists in an array of strings.
    public static boolean searchString(String[] arr, String target) {
        for (String s : arr) {
            if (s.equalsIgnoreCase(target))
                return true;
        }
        return false;
    }

    // Activity 4 : Custom Search Condition
    // Task 6 > Write a program to find the first number greater than a given value in an array.
    public static int firstGreaterThan(int[] arr, int value) {
        for (int num : arr) {
            if (num > value)
                return num;
        }
        return -1;
    }

    // Activity 5 : Practical Usage
    // Task 7 > Create a method that finds the index of a student name from an array of student names.
    // Task 8 > Print a message “Student found at index X” or “Student not found” accordingly.
    public static void findStudent(String[] students, String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                System.out.println("Student found at index " + i);
                return;
            }
        }
        System.out.println("Student not found");
    }

    // Main Method to Test All Activities
    public static void main(String[] args) {

        // Linear Search
        int[] nums = { 5, 3, 8, 2, 7 };
        System.out.println("Linear Search for 8: Index " + linearSearch(nums, 8));

        // Binary Search
        int[] sortedNums = { 1, 3, 5, 7, 9, 11 };
        System.out.println("Binary Search for 7: Index " + binarySearch(sortedNums, 7));

        // Search String
        String[] fruits = { "Apple", "Banana", "Mango", "Orange" };
        System.out.println("Is 'Mango' present? " + searchString(fruits, "Mango"));

        // First Greater Than
        int greater = firstGreaterThan(nums, 4);
        System.out.println("First number greater than 4: " + greater);

        // Find Student
        String[] students = { "Ayaan", "Riya", "Hanzala", "Tara" };
        findStudent(students, "Hanzala");
        findStudent(students, "Ali");
    }
}

