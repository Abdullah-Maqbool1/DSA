class PrintJob {
    String jobName;

    public PrintJob(String jobName) {
        this.jobName = jobName;
    }

    public String toString() {
        return jobName;
    }
}

class PrintQueue {
    private Node front, rear;

    private class Node {
        PrintJob data;
        Node next;

        Node(PrintJob data) {
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(PrintJob job) {
        Node newNode = new Node(job);
        if (rear != null) rear.next = newNode;
        rear = newNode;
        if (front == null) front = rear;
    }

    public PrintJob dequeue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        PrintJob job = front.data;
        front = front.next;
        if (front == null) rear = null;
        return job;
    }

    public PrintJob peek() {
        if (front == null) return null;
        return front.data;
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = front;
        System.out.println("Print Queue:");
        while (temp != null) {
            System.out.println(" -~~> " + temp.data);
            temp = temp.next;
        }
    }
}

public class PrintJobManagementSystem {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();

        queue.enqueue(new PrintJob("Job1: job1.pdf"));
        queue.enqueue(new PrintJob("Job2: job2.docx"));
        queue.enqueue(new PrintJob("Job3: job3.xlsx"));

        queue.display();

        System.out.println("Current Job: " + queue.peek());

        System.out.println("Processing: " + queue.dequeue());
        queue.display();

        queue.enqueue(new PrintJob("Job4: job4.pptx"));
        queue.display();
    }
}
