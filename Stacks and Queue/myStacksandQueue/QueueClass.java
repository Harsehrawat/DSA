package myStacksandQueue;


import java.util.NoSuchElementException;

public class QueueClass<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public QueueClass() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Add element to rear of queue
    public void add(T item) {
        if (size == arr.length) {
            resize();
        }
        arr[rear] = item;
        rear = (rear + 1) % arr.length;
        size++;
    }

    // Remove element from front of queue
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = arr[front];
        arr[front] = null; // Help GC
        front = (front + 1) % arr.length;
        size--;
        return item;
    }

    // Peek at front element without removing
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return arr[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //  Resize the array when full
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = arr.length * 2;
        T[] newArr = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        }

        arr = newArr;
        front = 0;
        rear = size;
    }
}
