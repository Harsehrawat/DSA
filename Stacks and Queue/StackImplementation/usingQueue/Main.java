package usingQueue;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main{

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        for(int i = 0; i<=6; i++){
            stack.pushSafe(
                i,
                val -> System.out.println(val + " added into stack!"), 
                () -> { System.out.println("Stack Overflow"); }
            );
        }
        
        stack.peekSafe(
            val -> System.out.println(val + " peeked"), 
            () -> { System.out.println(" Stack underflow for Peek"); }
        );

        stack.popSafe(
            val -> System.out.println(val + " popped"), 
            () -> { System.out.println(" Stack underflow for Pop"); }
        );

    }

}