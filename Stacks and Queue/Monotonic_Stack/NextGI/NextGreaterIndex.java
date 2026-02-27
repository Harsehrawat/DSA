package NextGI;

import java.util.Stack;

class NextGreaterIndex{
    // knows/ contains
    int[] res;


    // contract
    public int[] getNextGI( int[] arr){
        Stack< Integer> stack = new Stack<>();
        res = new int[ arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            int currEl = arr[ i];

            while( !stack.isEmpty() && currEl >= arr[ stack.peek()]){
                stack.pop();
            }

            int ngi = ( stack.isEmpty()) ? -1 : stack.peek();
            
            stack.push( i);
            res[ i] = ngi;
        }

        return res;
    }
}