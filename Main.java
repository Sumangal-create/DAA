import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // (a) Binary Search
        System.out.println("=== (a) BINARY SEARCH ===");

        System.out.print("Enter number of elements for sorted array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();

        int index = binarySearch(arr, 0, n - 1, target);

        if (index != -1) {
            System.out.println("Result: Target " + target +
                               " found at index " + index);
        } else {
            System.out.println("Result: Target " + target +
                               " not found in array");
        }


        // (b) Merge Sort
        System.out.println("\n=== (b) MERGE SORT ===");

        System.out.print("Enter number of elements for unsorted array: ");
        int m = sc.nextInt();

        int[] numbers = new int[m];

        System.out.println("Enter " + m + " integers:");
        for (int i = 0; i < m; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(numbers));

        mergeSort(numbers, 0, m - 1);

        System.out.println("Sorted Array: " + Arrays.toString(numbers));


        // (c) Sum of First N Factorials
        System.out.println("\n=== (c) SUM OF FIRST N FACTORIALS ===");

        System.out.print("Enter N: ");
        int factN = sc.nextInt();

        long factorialSum = sumFactorials(factN);

        System.out.println("Result: Sum of first " + factN +
                           " factorials = " + factorialSum);


        // (d) Sum of First N Fibonacci Numbers
        System.out.println("\n=== (d) SUM OF FIRST N FIBONACCI NUMBERS ===");

        System.out.print("Enter N: ");
        int fibN = sc.nextInt();

        long fibonacciSum = sumFibonacci(fibN);

        System.out.println("Result: Sum of first " + fibN +
                           " Fibonacci numbers = " + fibonacciSum);

        sc.close();
    }


    // ==============================
    // (a) RECURSIVE BINARY SEARCH
    // ==============================

    static int binarySearch(int[] arr, int low, int high, int target) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearch(arr, low, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, high, target);
        }
    }


    // ==============================
    // (b) RECURSIVE MERGE SORT
    // ==============================

    static void mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }


    static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (i = low, k = 0; i <= high; i++, k++) {
            arr[i] = temp[k];
        }
    }


    // ==============================
    // (c) SUM OF FIRST N FACTORIALS
    // ==============================

    static long factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    static long sumFactorials(int n) {

        if (n == 0) {
            return 0;
        }

        return factorial(n) + sumFactorials(n - 1);
    }


    // ==============================
    // (d) SUM OF FIRST N FIBONACCI NUMBERS
    // ==============================

    static long fibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    static long sumFibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        return fibonacci(n - 1) + sumFibonacci(n - 1);
    }
}