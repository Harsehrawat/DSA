import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total no. of elements to be put in array : ");
        int n =sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Start Filling the value for the Array : ");
        for(int i = 0;i<n;i++){
            System.out.println("Enter value of element : "+(i+1));
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1, new int[n]);
        System.out.println("Below is your array in sorted order : ");
        System.out.println("[");
        for(int i : arr){
            System.out.println(i+", ");
        }
        System.out.print("]");
    }

    static void mergeSort(int[] arr, int low, int high, int[] helperArray) {
        if (low >= high) return;

        int middle = low + (high - low) / 2;

        mergeSort(arr, low, middle, helperArray);
        mergeSort(arr, middle + 1, high, helperArray);

        mergeOperation(arr, low, middle, high, helperArray);
    }

    static void mergeOperation(int[] arr, int low, int middle, int high, int[] helperArray) {
        int leftPoint = low;
        int rightPoint = middle + 1;
        int helperPointer = low;

        // Merge the two sorted halves into helperArray
        while (leftPoint <= middle && rightPoint <= high) {
            if (arr[leftPoint] <= arr[rightPoint]) {
                helperArray[helperPointer++] = arr[leftPoint++];
            } else {
                helperArray[helperPointer++] = arr[rightPoint++];
            }
        }

        // Copy remaining elements from left half
        while (leftPoint <= middle) {
            helperArray[helperPointer++] = arr[leftPoint++];
        }

        // Copy remaining elements from right half
        while (rightPoint <= high) {
            helperArray[helperPointer++] = arr[rightPoint++];
        }

        // Copy back the merged content to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = helperArray[i];
        }
    }
}
