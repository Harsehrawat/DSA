//Write a rec. fn to multiply two +ve integers without using the * operator.
// You can use the addition,subtraction or bit shifting .
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write value of 1st Number : ");
        int a = sc.nextInt();
        System.out.println("Write value of 2nd Number :");
        int b = sc.nextInt();

        int ans = fn(a, b,0);
        System.out.println("The multiplication of "+a+" and "+b+" is : "+ans);

    }
    static int fn(int a,int b,int prod){
        if(b == 0) return prod;
        prod += a;
        return fn(a, b-1,prod);
    }
}