package usingArray;

class Queue{
    // know/ contains ??

    private int[] arr;
    private int start;
    private int end;

    // constructor
    public Queue( int size){
        arr = new int[ size];
        start = 0;
        end = -1;
    }

    // contract

    public void offer( int x){
        if( end == arr.length - 1) throw new RuntimeException("Queue OverFlow");

        end ++;
        arr[ end] = x;
    }

    public int peek(){ // returns firstElement in arr
        if( end == -1) throw new RuntimeException("Queue Underflow");

        int res = arr[ start];
        return res;
    }

    public int pop(){
        if(isEmpty()) throw new RuntimeException("Queue Underflow");
        int res = arr[start];
        start++;
        if(start > end) { // queue is now empty
            start = 0;
            end = -1;
        }
        return res;
    }

    public int size(){
        return end - start + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains( int x){
        for( int i = start; i <= end; i++){
            if( arr[ i] == x) return true;
        }

        return false;
    }

}