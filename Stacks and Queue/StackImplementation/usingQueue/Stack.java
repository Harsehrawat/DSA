package usingQueue;

import java.util.LinkedList;
import java.util.Queue;

class Stack{
    // what does it know/ contains..
    Queue< Integer> q;
    int end;
    int capacity;

    // constructor..
    public Stack( int capacity){
        q = new LinkedList<>();
        end = -1;
        this.capacity = capacity;
    }


    // contract for Stack class.. push, pop, peek, size, contains, isEmpty

    public void push( int x){
        if( q.size() == capacity) throw new RuntimeException("Stack overflow");

        // queue follows FIFO.. and Stack wants latest elemnt to get removed first..
        // so to get latest element in first in q.. remove ( size() - 1) elements from queue & insert them again at last of queue
        
        // add x to q
        q.offer(x);

        // Step 2: rotate previous elements
        for(int i = 0; i< q.size() - 1; i++){
            int qFrontEl = q.poll();
            q.add(qFrontEl); // keep ådding in later sequence now 
        }
    }

    public int pop(){
        if( q.size() == 0) throw new RuntimeException("stack underflow");

        return q.poll();
    }

    public int peek(){
        if( q.size() == 0) throw new RuntimeException("stack underflow");

        return q.peek();
    }

    public int size(){ 
        return q.size();
    }

    public boolean contains( int x){ return q.contains( x); }

    public boolean isEmpty(){ return q.isEmpty(); }

    public void clear(){ q.clear(); }
}