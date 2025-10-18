// Day 4 : Sorting Algorithms

// Activity 1 : Bubble Sort
// Task 1 > Implement bubble sort to sort an array of numbers in ascending order.
// Task 2 > Modify bubble sort to sort an array of numbers in descending order.

public class SortingAlgorithms {
    // Bubble Sort Ascending
    public static void bubbleSortAsc(int[] arr) {
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

    // Bubble Sort Descending
    public static void bubbleSortDesc(int[] arr) {
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

    // Activity 2 : Selection Sort
    // Task 3 > Implement selection sort to sort an array.
    // Task 4 > Print the array after every pass.

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.print("After pass " + (i + 1) + ": ");
            for (int num : arr) System.out.print(num + " ");
            System.out.println();
        }
    }

    // Activity 3 : Insertion Sort
    // Task 5 > Implement insertion sort to sort an array.
    // Task 6 > Print the sorted array.

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Activity 4 : Sorting Practice
    // Task 7 > Sort an array of strings alphabetically.
    // Task 8 > Sort a list of custom objects (students) by marks in descending order.

    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        // Activity 1
        int[] arr1 = {5, 3, 8, 4, 2};
        bubbleSortAsc(arr1);
        System.out.print("Bubble Sort Ascending: ");
        for (int i : arr1) System.out.print(i + " ");
        System.out.println();

        int[] arr2 = {5, 3, 8, 4, 2};
        bubbleSortDesc(arr2);
        System.out.print("Bubble Sort Descending: ");
        for (int i : arr2) System.out.print(i + " ");
        System.out.println("\n");

        // Activity 2
        int[] arr3 = {64, 25, 12, 22, 11};
        selectionSort(arr3);
        System.out.println();

        // Activity 3
        int[] arr4 = {9, 5, 1, 4, 3};
        insertionSort(arr4);
        System.out.print("Insertion Sort Result: ");
        for (int i : arr4) System.out.print(i + " ");
        System.out.println("\n");

        // Activity 4
        String[] names = {"Zara", "Adam", "Mia", "John"};
        java.util.Arrays.sort(names);
        System.out.print("Sorted Strings: ");
        for (String n : names) System.out.print(n + " ");
        System.out.println();

        java.util.List<Student> students = new java.util.ArrayList<>();
        students.add(new Student("Ayaan", 85));
        students.add(new Student("Riya", 92));
        students.add(new Student("Karan", 78));

        students.sort((s1, s2) -> s2.marks - s1.marks);
        System.out.println("Students sorted by marks:");
        for (Student s : students)
            System.out.println(s.name + " -> " + s.marks);
    }
}
