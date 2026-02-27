package NextGE;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGreaterElement {
    // knows/ contains..
    int[] res;

    // contract..
    public NextGreaterElement(){};

    public int[] nextGE( int[] arr){
        Stack< Integer> stack = new Stack<>();
        res = new int[ arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            int currEl = arr[ i];

            while( !stack.isEmpty() && currEl >= stack.peek()){
                stack.pop();
            }

            int nge = ( stack.isEmpty()) ? -1 : stack.peek();
            
            stack.push( currEl);
            res[ i] = nge;
        }

        return res;
    }
    
}