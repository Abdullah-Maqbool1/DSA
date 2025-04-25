class CircularQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = size = 0;
        rear = -1;
    }

    public void enqueue(String caller) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot add: " + caller);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = caller;
        size++;
    }

    public String dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return null;
        }
        String caller = queue[front];
        front = (front + 1) % capacity;
        size--;
        return caller;
    }

    public String peek() {
        if (size == 0) return null;
        return queue[front];
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Callers in queue:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println(" - " + queue[index]);
        }
    }
}

public class CallCenterSupportSystem {
    public static void main(String[] args) {
        CircularQueue callQueue = new CircularQueue(5);

        callQueue.enqueue("Caller 1");
        callQueue.enqueue("Caller 2");
        callQueue.enqueue("Caller 3");

        callQueue.display();

        System.out.println("Next Caller: " + callQueue.peek());

        System.out.println("Connecting: " + callQueue.dequeue());
        callQueue.display();

        callQueue.enqueue("Caller 4");
        callQueue.enqueue("Caller 5");
        callQueue.enqueue("Caller 6");
        callQueue.display();
    }
}