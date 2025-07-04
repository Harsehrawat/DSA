// in an array of integers, a "peak" is an element which is greater than or equal to the adjacent elements,
// and a "valley" is an element which is less than or equal to the adjacent elements,
// For ex., in the array {5,8,6,2,3,4,6}, peaks are : [8,6] , valleys are : [5,2]
// Given an array of integers, sort the array into an alternating sequence of peaks and valleys .
// ex. input : [5,3,1,2,3]
// ex. output: [5,1,3,2,3] 

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5,3,2,1,3};

        // i'll sort the array
        // i'd have a peakPtr. starting from 0th index , 
        // i'd have a valleyPtr. starting from 1st index ,
        // both the ptr. will move skipping next index,
        // i'll run a loop till peakPtr. < arr.length
        // keep filling from array in peakPtr. 
        int[] ans = new int[arr.length];

        reverseSort(arr);
        int peakPtr = 0;
        int i = 0;
        while (peakPtr < arr.length) {
            ans[peakPtr] = arr[i];
            System.out.println("PeakPtr. at : "+peakPtr+" , adding element : "+arr[i]);
            peakPtr += 2;
            i++;
        }

        // now continue from end till i
        int valleyPtr = 1;
        int j = arr.length-1;
        while (j >= i) {
            ans[valleyPtr] = arr[j];
            System.out.println("ValleyPtr. at : "+valleyPtr+" , adding element : "+arr[j]);
            valleyPtr += 2;
            j--;
        }

        System.out.print("[");
        for(int k : ans){
            System.out.print(k+", ");
        }
        System.out.print("]");
    }
    static void reverseSort(int[] arr){
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(arr);
        for(int i : arr){
            stack.push(i);
        }
        int j = 0;
        while (!stack.isEmpty()) {
            arr[j] = stack.pop();
            j++;
        }
    }
    
}