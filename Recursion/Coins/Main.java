// given we've four type of coins : 
// quarter : 25 cents , dimes : 10 cents , nickels : 5 cents and pennies : 1 cent
// write an algorithm to determine no. of way to sum up to 'n' coins
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] coins = {25,10,5,1};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n :");
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][coins.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = fn(n,coins,0,dp);
        System.out.println(n+" can be achieved by "+ans+" different ways !" );
    }
    static int fn(int n,int[] coins,int index, int[][] dp){
        if (n == 0) {
            return 1;
        }

        if( n < 0 || index >= coins.length) return 0;

        if(dp[n][index] != -1) { 
            return dp[n][index];
        }

        // either repeat on currBlock or move to nextBlock
        int repeat = fn(n - coins[index], coins,index, dp);
        int tryNextCurr = fn(n, coins, index+1, dp);

        return dp[n][index] = repeat + tryNextCurr;
    }
}