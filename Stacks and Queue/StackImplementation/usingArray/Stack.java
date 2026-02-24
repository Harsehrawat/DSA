// Stack methods: push, pop, peek, isEmpty, size, {OPTIONAL: clear, contains}

package usingArray;

// implementing using Arrays..
class Stack {
    // what should it know/contain ..
    private int[] arr;
    private int top; // idx of topEl

    // constructor..
    public Stack( int capacity){
        arr = new int[ capacity];
        top = -1;
    }


    // things my Stack object should do..( methods)

    public void push( int x){
        // should push be allowed if stack is full for its capacity..
        if( top == arr.length - 1) throw new RuntimeException("Stack overflow");
            
        top++;
        arr[ top] = x;
        
    }

    public int pop(){
        // should pop be called when stack is already empty ??
        if( top == -1) throw new RuntimeException("Stack Underflow");
            
        // return top idx el & remove it from stack..
        int topEl = arr[ top];
        top --;
        return topEl;
    }

    public int peek(){
        if( top == -1) throw new RuntimeException("Stack underflow");

        // return top idx el
        return arr[ top];
    }

    public boolean isEmpty(){
        // return if top == -1
        return ( top == -1) ? true: false;
    }

    public int size(){
        // size -> top+1
        return top + 1;
    }

    public boolean contains( int x){
        for(int i = 0; i <= top; i++){
            if(arr[i] == x) return true;
        }
        return false;
    }

    public void clear(){
        // empty the array..
        top = -1;
    }
    
}