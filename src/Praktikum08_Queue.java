public class Praktikum08_Queue {
    int[] element;
    int front;
    int rear;
    int maxQueue;

    public Praktikum08_Queue(int max) {
        front = 0;
        rear = -1;
        element = new int[max];
        maxQueue = max - 1;
    }
    public boolean isEmpty() {
        boolean flag;
        if((rear == -1) && (front == 0)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public boolean isFull() {
        boolean flag;
        if(rear == maxQueue-1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public void Enqueue(int data) {
        if(isFull()) {
            System.out.println("Overflow Condition of Queue");
        } else {
            rear += 1; // rear = rear + 1
            element[rear] = data;
        }
    }

    public int Dequeue() {
        int data = 0;
        if(isEmpty()) {
            System.out.println("Underflow Condition if Queue");
        } else {
            data = element[front];
            element[front] = 0;
            front += 1; // front = front + 1
        }
        return data;
    }
    public int FrontData() {
        if(isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return element[front];
        }
    }
    public int RearData() {
        if(isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return element[rear];
        }
    }

    public void printQueue() {
        if(!isEmpty()) {
            System.out.println("Data of Queue: ");
            System.out.print("[");
            for(int i=front; i<=rear; i++) {
                System.out.print(" " + element[i] + " ");
            }
            System.out.println("]");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public static void main(String[] args) {
        Praktikum08_Queue s = new Praktikum08_Queue(10);
        s.Enqueue(10);
        s.Enqueue(20);
        s.Enqueue(30);
        s.Enqueue(40);

        s.printQueue();
        s.Dequeue();
        s.printQueue();
        System.out.println("Elemen front: " + s.FrontData());
        System.out.println("Elemen rear: " + s.RearData());
    }
}
