package _00_algo._000_solA._000_base;

public class _004_Queue_4_RingBuffer {
    public static void main(String[] args) {

    }
}

class RingBufferQueue {
    int[] data;
    int front; // dequeue index
    int rear;  // enqueue index
    int capacity;

    public RingBufferQueue(int size) {
        capacity = size + 1; // 한 칸 비워두기
        data = new int[capacity];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }

    public boolean offer(int x){
        if (isFull()) return false;
        data[rear] = x;
        rear = (rear + 1) % capacity;
        return true;
    }

    public int poll(){
        if (isEmpty()) return -1;
        int val = data[front];
        front = (front + 1) % capacity;
        return val;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return data[front];
    }
}

