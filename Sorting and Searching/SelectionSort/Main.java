// it's simple algo but in-efficient algo .
// find the smallest el using linear search and place it to the front {opposite of Bubble Sort}

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
        selection_Sort(arr);
        System.out.println("Below is your array in sorted order : ");
        System.out.println("[");
        for(int i : arr){
            System.out.println(i+", ");
        }
        System.out.print("]");

    }
    static void selection_Sort(int[] arr){
        int smallFound = 0;
        while (smallFound < arr.length) {
            int smallestEl = Integer.MAX_VALUE;
            int smallestEl_Index = 0;
            for(int i = smallFound;i<arr.length;i++){
                if(arr[i] < smallestEl){
                    smallestEl_Index = i;
                    smallestEl = arr[i];
                }
            }
            swap(arr,smallestEl_Index,smallFound );
            smallFound ++ ;
        }
    }
    static void swap(int[] arr,int index1,int index2){
        if(index1 == index2) return;
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}