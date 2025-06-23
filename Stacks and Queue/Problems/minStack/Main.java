package Problems.minStack;

import myStacksandQueue.StackClass;

public class Main {
    public static void main(String[] args) {
        StackClass<Integer> stack = new StackClass<>();
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(15);

        Logic logic = new Logic();
        logic.minElement(stack); // Output: Minimum element in the stack is: 5

        stack.printStack();
    }
}
