// You have a stack of n boxes, with widths wi, heights hi, and depths di.
// The boxes cannot  be rotated and can only be stacked on top of one another if each box in the staack is strictly larger than 
// the box above it in width, height and depth.
// Implement a method to compute the height of the tallest possible stack. 
// the height of a stack is the sum of the heights of each box.

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public class Box {
        int w;
        int h;
        int d;

        Box(int w,int h,int d){
            this.w = w;
            this.h = h;
            this.d = d;
        }
        
        boolean verifyPlacing(Box b){
            return this.w < b.w && this.h < b.h && this.d < b.d;
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total no. of Boxes : ");
        int n = sc.nextInt();
        
        List<Box> boxes = new ArrayList<>();

        for(int i = 0;i<n;i++){
            System.out.println("Enter width of box number : "+i+1);
            int w = sc.nextInt();
            System.out.println("Enter height of box number : "+i+1);
            int h = sc.nextInt();
            System.out.println("Enter depth of box number : "+d);
            int d = sc.nextInt();
            // add box to list
            boxes.add(new Box(w, h, d));
        }

        // sort based on max height
        boxes.sort((a,b) -> b.h - a.h); 
        int[] dp = new int[boxes.size()];
        Arrays.fill(dp, -1);
    }
}