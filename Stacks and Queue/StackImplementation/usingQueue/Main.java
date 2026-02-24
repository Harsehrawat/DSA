package usingQueue;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main{

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        try {
            System.out.println(stack.peek());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        stack.push(4);
        stack.push(5);
        // Handle overflow safely
        try {
            stack.push(6);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Size: " + stack.size());

        stack.clear();

        // Handle underflow safely
        try {
            System.out.println(stack.peek());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}