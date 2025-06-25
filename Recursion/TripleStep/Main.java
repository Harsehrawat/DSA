// A child is running up a staircase with n steps and can hop either 1 step, 2 step or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.

package Recursion.TripleStep;

public class Main {
    public static void main(String[] args) {
        int ans = fn(3);
        System.out.print(ans);
    }
    static int fn(int n){
        if(n==0){
            return 1;
        }
        if(n < 0) return 0;

        return fn(n-1) + fn(n-2) + fn(n-3);

    }
}