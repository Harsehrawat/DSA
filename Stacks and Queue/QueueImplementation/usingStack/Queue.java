package usingStack;

import java.util.Stack;

class Queue {
    // contains/ konw
    Stack< Integer> stack;
    int end;

    // constructor
    public Queue( int size){
        stack = new Stack<>();
        this.end = size;
    }

    // contract
    public void offer(int x) {
        if (stack.size() >= end) throw new RuntimeException("Queue Overflow");

        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int top = stack.pop();
            offer(x);       // recursive call
            stack.push(top); // put back the previous top
        }
    }

    public int peek(){
        if( stack.isEmpty()) throw new RuntimeException("Queue Underflow");

        return stack.peek();
    }

    public int pop(){
        if( stack.isEmpty()) throw new RuntimeException("Queue Underflow");

        return stack.pop();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){ return stack.isEmpty(); }

    public boolean contains( int x){ return stack.contains( x); }

}