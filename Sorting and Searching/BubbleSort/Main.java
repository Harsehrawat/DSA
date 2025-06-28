// pair-wise from start .
// the largest el gets to end in each iteration

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
        bubble_Sort(arr);
        System.out.println("Below is your array in sorted order : ");
        System.out.println("[");
        for(int i : arr){
            System.out.println(i+", ");
        }
        System.out.print("]");
    }
    static void bubble_Sort(int[] arr){
        int end = arr.length;
        while (end>1) {
            for(int i = 1;i<end;i++){
                if(arr[i] < arr[i-1]) swap(arr,i,i-1);
    
            }
            end --;
        }
        
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}