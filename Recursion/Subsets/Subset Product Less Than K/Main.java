// 🧩 Problem: Subset Product Less Than K
// Given:

// An array of positive integers arr of length n.
// A positive integer k.
// Task:
// Print all subsequences (of any length ≥ 1) whose product of elements is strictly less than k.

// 🔍 Example:
// Input:

// arr = [2, 4, 1]
// k = 10
// Valid subsequences (with product < 10):

// [2]
// [4]
// [1]
// [2, 4] → product = 8 ✅
// [2, 1] → product = 2 ✅
// [4, 1] → product = 4 ✅
// [2, 4, 1] → product = 8 ✅

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        System.out.println("Enter Length of Array : ");
        n = sc.nextInt();
        System.out.println("Enter value of k :");
        k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            System.out.println("Enter value of Element : "+(i+1)+" of the Array");
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        fn(arr,ans, 0, 1, k);


    }
    static void fn(int[] arr,ArrayList<Integer> ans,int index,int currProd,int k){
       // base case..
       if(index == arr.length) return;
       
       int newProd = currProd * arr[index];
       ans.add(arr[index]);
       // if valid .. take otherwise skip
       if(newProd < k){
        // print valis subsequences
        System.out.println(ans);
        fn(arr, ans, index+1, newProd, k);
       }
       // skip
       // back-track from ans
       ans.remove(ans.size()-1);
       fn(arr, ans, index+1, currProd, k);
    }
}