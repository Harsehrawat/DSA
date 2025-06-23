package myStacksandQueue;


import java.util.EmptyStackException;

public class StackClass<T> { // generic class
    private static final int DEFAULT_CAPACITY = 10;
    public T[] arr;    // generic array
    public int top;

    @SuppressWarnings("unchecked")
    public StackClass() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    public void push(T item) {
        if (top == arr.length) {
            resize();
        }
        arr[top++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = arr[--top];
        arr[top] = null;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int getSize(){
        return arr.length;
    }

    public void printStack(){
        for(T i : arr){
            if(i != null) System.out.println(i);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = arr.length * 2;     // automatic resize if want to add a new elemtn to full stack
        T[] newArr = (T[]) new Object[newCapacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
