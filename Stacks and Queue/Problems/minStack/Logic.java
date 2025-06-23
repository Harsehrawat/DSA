package Problems.minStack;

import java.util.Stack;

import myStacksandQueue.StackClass;


public class Logic {

    public void minElement(StackClass<Integer> stack){
        if(stack.isEmpty()){
            System.out.println("Provided Stack is Empty, can't perform minStack Operation");
            return;
        }

        StackClass<Integer> tempStack = new StackClass<>();
        int minFound = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            // pop and push to tempStack while tracking minFOund
            int currEl = stack.pop();
            if(currEl < minFound) minFound = currEl;

            tempStack.push(currEl);
        }

        System.out.println("The min Element in the stack is : "+minFound);

        // restore to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}