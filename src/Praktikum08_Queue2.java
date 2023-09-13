public class Praktikum08_Queue2 {
    int front, rear, maxQueue;
    int[] elemen;
    public Praktikum08_Queue2(int max) {
        front = 0;
        rear = -1;
        elemen = new int[max];
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
        if(rear == maxQueue) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public void Enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue Overflow");
        } else {
            rear += 1; //rear = rear + 1;
            elemen[rear] = data;
        }
    }
    public int Dequeue() {
        int data = 0;
        if(isEmpty()) {
            System.out.println("Queue Underflow");
        } else {
            data = elemen[front];
            elemen[front] = 0;
            front += 1; // front = front + 1
        }
        return data;
    }
    public int Front() {
        if(isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return elemen[front];
        }
    }
    public int Rear() {
        if(isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return elemen[rear];
        }
    }
    public void printQueue() {
        if(!isEmpty()) {
            System.out.println("Data of Queue: ");
            System.out.print("[");
            for(int i=rear; i>-1; i--){
                System.out.print(" " + elemen[i] + " ");
            }
            System.out.println("]");
        } else {
            System.out.println("Queue is still empty");
        }
    }

    public static void main(String[] args) {
        Praktikum08_Queue2 s = new Praktikum08_Queue2(10);
        s.Enqueue(10);
        s.Enqueue(40);
        s.Enqueue(30);
        s.Enqueue(20);
        s.Enqueue(50);

        s.printQueue();
        s.Dequeue();
        s.printQueue();
        System.out.println("Front Elemen: " + s.Front());
        System.out.println("Rear Elemen: " + s.Rear());
    }
}
