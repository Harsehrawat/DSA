package usingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Stack{
    // what does it know/ contains..
    Queue< Integer> q;
    int capacity;

    // constructor
    public Stack( int size){
        q = new LinkedList<>();
        this.capacity = size;
    }

    // contract..
    // push( x), peek(), pop(), contains(), isEmpty(), size(), clear()

    public void pushSafe( int x, Consumer< Integer> onSuccess, Runnable onError){
        if( q.size() == capacity){
            onError.run();
            return;
        }

        q.offer( x);
        for(int i = 0; i< q.size() - 1; i++){
            q.add(q.poll());
        }

        onSuccess.accept(x);

    }

    public void peekSafe( Consumer< Integer> onSuccess, Runnable onError){
        if( q.size() == 0){
            onError.run();
            return;
        }

        onSuccess.accept(q.peek());
    }

    public void popSafe( Consumer< Integer> onSuccess, Runnable onError){
        if( q.size() == 0){
            onError.run();
            return;
        }

        onSuccess.accept(q.poll());
    }

    public boolean contains( int x){
        if( q.contains(x)) return true;
        return false;
    }

    public boolean isEmpty(){ return q.isEmpty(); }

    public int size(){ return q.size(); }

}