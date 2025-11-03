// Day - 17 : Sorting Algorithms (Part 1)

import java.util.*;

public class Day17_Sorting {

    // Activity 1 : Bubble Sort
    // Task 1 > Implement Bubble Sort
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

    // Task 2 > Bubble Sort in Descending Order
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
    // Task 3 > Implement Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Task 4 > Count number of swaps in Selection Sort
    public static int selectionSortCount(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    // Activity 3 : Insertion Sort
    // Task 5 > Implement Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Task 6 > Sort Strings Alphabetically
    public static void insertionSortStrings(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Activity 4 : Conditional Sorting
    // Task 7 > Sort only odd numbers
    public static void sortOddNumbersOnly(int[] arr) {
        List<Integer> odds = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 != 0)
                odds.add(num);
        }
        Collections.sort(odds);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                arr[i] = odds.get(index++);
        }
    }

    // Task 8 > Sort students by marks
    static class Student {
        String name;
        int marks;
        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void sortStudentsByMarks(Student[] students) {
        Arrays.sort(students, (a, b) -> a.marks - b.marks);
    }

    // Activity 5 : Dynamic Sorting
    // Task 9 & 10 > Dynamic Sorting Algorithm
    public static void dynamicSort(int[] arr, String method) {
        switch (method.toLowerCase()) {
            case "bubble":
                bubbleSort(arr);
                break;
            case "selection":
                selectionSort(arr);
                break;
            case "insertion":
                insertionSort(arr);
                break;
            default:
                System.out.println("Invalid method name!");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 1};
        int[] arr2 = {5, 2, 8, 3, 1};
        String[] words = {"banana", "apple", "grape", "cherry"};

        System.out.println("---- Bubble Sort ----");
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("\n---- Bubble Sort Desc ----");
        bubbleSortDesc(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("\n---- Selection Sort ----");
        int[] selectionArr = {64, 25, 12, 22, 11};
        selectionSort(selectionArr);
        System.out.println(Arrays.toString(selectionArr));

        System.out.println("\n---- Selection Sort Swap Count ----");
        int[] selectionArr2 = {64, 25, 12, 22, 11};
        System.out.println("Swaps: " + selectionSortCount(selectionArr2));

        System.out.println("\n---- Insertion Sort ----");
        int[] insertionArr = {9, 5, 1, 4, 3};
        insertionSort(insertionArr);
        System.out.println(Arrays.toString(insertionArr));

        System.out.println("\n---- Insertion Sort for Strings ----");
        insertionSortStrings(words);
        System.out.println(Arrays.toString(words));

        System.out.println("\n---- Sort Only Odd Numbers ----");
        int[] mix = {5, 8, 3, 2, 7, 6};
        sortOddNumbersOnly(mix);
        System.out.println(Arrays.toString(mix));

        System.out.println("\n---- Sort Students by Marks ----");
        Student[] students = {
            new Student("Aman", 85),
            new Student("Rahul", 92),
            new Student("Sayed", 78)
        };
        sortStudentsByMarks(students);
        for (Student s : students)
            System.out.println(s.name + " : " + s.marks);

        System.out.println("\n---- Dynamic Sort ----");
        int[] dynamicArr = {4, 1, 3, 9, 7};
        dynamicSort(dynamicArr, "insertion");
        System.out.println(Arrays.toString(dynamicArr));
    }
}


