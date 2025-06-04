// You are given an array arr and an integer k.
// A subsequence of an array is cool if
// The number of odd elements in the subsequences should be even
// The size of subsequence is k.
// Print the sum of product of cool subsequences of array 

// Example :
// Input
// 4 2
// 1 4 5 7
// Output
// 47
// Explanation
// The cool subsequences are


// [5, 7]

// [1, 7]

// [1, 5]


// The sum of their products = 5*7 + 1*7 +  1*5 = 47.


import java.util.ArrayList;
import java.util.Scanner;

class CoolArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide value of n : ");
        int n = sc.nextInt();
        System.out.println("Provide value of k : ");
        int k = sc.nextInt();
        
        int[] arr=  new int[n];
        for(int i = 0;i<n;i++){
            System.out.println("Enter value of element : "+(i+1)+" of the array");
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> ans= new ArrayList<>();
        fn(arr, ans, k, 0, 0, 0);

    }
    static void fn(int[] arr,ArrayList<Integer> ans,int k,int index,int size,int oddCount){
        // base case..
        if(size == k){
            // verify if oddCount satifies condn
            if(oddCount % 2 == 0){
                System.out.println(ans);
            }
            return;
        }

        if(size > k || index == arr.length) return;

        // enter into ans and validate oddCount
        int currEl = arr[index];
        ans.add(currEl);

        // rec. calls.. take or skip
        fn(arr, ans, k, index+1, size+1, oddCount + (currEl % 2 == 0 ? 0 : 1));
        // clear for skip
        ans.remove(ans.size() - 1);
        fn(arr, ans, k, index+1, size, oddCount);

    }
    
}