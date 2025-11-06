
// Day - 18 : Sorting Algorithms (Part 2)

import java.util.*;

public class Day18_Sorting {

    // Activity 1 : Merge Sort
    // Task 1 > Implement Merge Sort Ascending
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Task 2 > Merge Sort Descending
    private static void mergeDesc(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void mergeSortDesc(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortDesc(arr, left, mid);
            mergeSortDesc(arr, mid + 1, right);
            mergeDesc(arr, left, mid, right);
        }
    }

    // Activity 2 : Quick Sort
    // Task 3 > Quick Sort Ascending
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Task 4 > Quick Sort Descending
    public static void quickSortDesc(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionDesc(arr, low, high);
            quickSortDesc(arr, low, pi - 1);
            quickSortDesc(arr, pi + 1, high);
        }
    }

    private static int partitionDesc(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Activity 3 : Advanced Sorting Practice
    // Task 5 > Merge Sort Strings
    public static void mergeSortStrings(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortStrings(arr, left, mid);
            mergeSortStrings(arr, mid + 1, right);
            mergeString(arr, left, mid, right);
        }
    }

    private static void mergeString(String[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        String[] L = new String[n1];
        String[] R = new String[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Task 6 > Quick Sort Custom Objects (Student)
    static class Student {
        String name;
        int marks;
        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void quickSortStudents(Student[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionStudents(arr, low, high);
            quickSortStudents(arr, low, pi - 1);
            quickSortStudents(arr, pi + 1, high);
        }
    }

    private static int partitionStudents(Student[] arr, int low, int high) {
        int pivot = arr[high].marks;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].marks < pivot) {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Activity 4 : Sorting Analysis
    // Task 7 & 8 > Compare Merge vs Quick Sort speed
    public static void compareSortingTimes() {
        int[] arr1 = new Random().ints(10000, 0, 100000).toArray();
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        long start = System.nanoTime();
        mergeSort(arr1, 0, arr1.length - 1);
        long mergeTime = System.nanoTime() - start;

        start = System.nanoTime();
        quickSort(arr2, 0, arr2.length - 1);
        long quickTime = System.nanoTime() - start;

        System.out.println("Merge Sort Time: " + mergeTime / 1e6 + " ms");
        System.out.println("Quick Sort Time: " + quickTime / 1e6 + " ms");
        System.out.println("Faster: " + (mergeTime < quickTime ? "Merge Sort" : "Quick Sort"));
    }

    // Activity 5 : Challenge Problem
    // Task 9 > Count Inversions using Merge Sort
    public static long countInversions(int[] arr, int left, int right) {
        long inversions = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inversions += countInversions(arr, left, mid);
            inversions += countInversions(arr, mid + 1, right);
            inversions += mergeAndCount(arr, left, mid, right);
        }
        return inversions;
    }

    private static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        long swaps = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i);
            }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
        return swaps;
    }

    // Task 10 > Merge Two Sorted Arrays
    public static int[] mergeTwoSortedArrays(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) result[k++] = A[i++];
            else result[k++] = B[j++];
        }
        while (i < A.length) result[k++] = A[i++];
        while (j < B.length) result[k++] = B[j++];
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1, 6};
        System.out.println("Original Array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge Sort Asc: " + Arrays.toString(arr));

        int[] arrDesc = {4, 1, 7, 3, 9};
        mergeSortDesc(arrDesc, 0, arrDesc.length - 1);
        System.out.println("Merge Sort Desc: " + Arrays.toString(arrDesc));

        int[] quickArr = {10, 7, 8, 9, 1, 5};
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("Quick Sort Asc: " + Arrays.toString(quickArr));

        int[] quickArrDesc = {10, 7, 8, 9, 1, 5};
        quickSortDesc(quickArrDesc, 0, quickArrDesc.length - 1);
        System.out.println("Quick Sort Desc: " + Arrays.toString(quickArrDesc));

        String[] words = {"banana", "apple", "grape", "cherry"};
        mergeSortStrings(words, 0, words.length - 1);
        System.out.println("Merge Sort Strings: " + Arrays.toString(words));

        Student[] students = {
            new Student("Ali", 85),
            new Student("Hanzala", 95),
            new Student("Riya", 70)
        };
        quickSortStudents(students, 0, students.length - 1);
        System.out.println("Students sorted by marks:");
        for (Student s : students) System.out.println(s.name + ": " + s.marks);

        System.out.println("\n--- Sorting Comparison ---");
        compareSortingTimes();

        int[] invArr = {2, 4, 1, 3, 5};
        System.out.println("Inversion Count: " + countInversions(invArr, 0, invArr.length - 1));

        int[] merged = mergeTwoSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.println("Merged Sorted Arrays: " + Arrays.toString(merged));
    }
}


