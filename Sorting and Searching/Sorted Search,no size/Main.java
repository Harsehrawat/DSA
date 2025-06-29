// i am given an array like D.S. Listy which lacks a size method.
// It does, however, have an elementAt(i) which returns the element at index i in O(1) time.
// If i is beyond the bounds of the D.S. , it returns -1 .
// Given a listy which contains sorted, +ve integers, find the index at which an element x occurs .

import java.util.ArrayList;
import java.util.List;

class Listy {
    private List<Integer> data;
    
    public Listy(int[] arr){
        data = new ArrayList<>();
        for(int i : arr){
            data.add(i);
        }
    }

    int elementAt(int i){
        if(i < 0 || i >= data.size()) return -1;
        return data.get(i);
    }
    
}

public class Main {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Listy listy = new Listy(arr);

        int ans = findTargetIndex(listy,7, 0, 10);
        System.out.println(ans == -1 ? "No such element present " : "Target Element found at index : "+ans);

    }
    static int findTargetIndex(Listy listy,int target,int left , int right){
// let's assume right to be 10 , will adjust based on o/p from listy.elementAt(i)
        if(left > right) return -1;
        
        int middle = (left + right) / 2;
        int midVal = listy.elementAt(middle);
        if (midVal == target) return middle;

        if(listy.elementAt(right) != -1){
            System.out.println("right is at valid index currently poitning at index : "+right);
            // means i am at right search space 
            if(target <= listy.elementAt(right)){
                
                if(listy.elementAt(middle) > target){ // search in left space
                    System.out.println("trying to find for searchspace from index : "+left+ " to index :"+(middle-1));
                    return findTargetIndex(listy, target, left, middle-1);
                }
                else{System.out.println("trying to find for searchspace from index : "+(middle+1)+ " to index :"+right);
                    return findTargetIndex(listy, target,middle+1, right);
                }
            }
            else{
                // means i've to try expanding my right more 
                left = middle+1;
                right = 2 * right;

                // Debugging
                System.out.println("trying to find for searchspace from index : "+left+ " to index :"+right);
                return findTargetIndex(listy, target, left, right);
            }
        }
        else{
            // means i've to reduce my right 
            System.out.println("Right is at invalid index currently pointing at index : "+right);
            System.out.println("trying to find for searchspace from index : "+left+" to index :"+right/2);
            return findTargetIndex(listy, target, left,right/2);
        }

    }
    
}