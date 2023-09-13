public class Praktikum08_QueueCircular {
    int[] element;
    int front, rear, maxQueue;

    public Praktikum08_QueueCircular(int max) {
        front = 0;
        rear = -1;
        element = new int[max];
        maxQueue = max - 1;
    }
    public boolean isFull() {
        boolean flag = true;
        for(int i = 0; i <= maxQueue; i++){
            if(element[i] == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public boolean isEmpty() {
        boolean flag;
        if(rear < 0) {
            flag = true;
        } else{
            flag = false;
        }
        return flag;
    }

    public void Enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue Overflow");
        } else {
            if(rear != maxQueue) {
                rear += 1;
            } else {
                rear = 0;
            }
            element[rear] = data;
        }
    }

    public int Dequeue() {
        int data = 0;
        if(isEmpty()) {
            System.out.println("Queue Underflow");
        } else {
            data = element[front];
            element[front] = 0;
            if(front == maxQueue) {
                front = 0;
            } else  {
                front += 1;
            }
        }
        return data;
    }
    public void printQueue() {
        if(!isEmpty()) {
            System.out.println("Menampilkan urutan dari posisi tertinggi: ");
            for(int i = rear; i > -1; i--) {
                System.out.println("Elemen ke-" + i + " = " + element[i]);
            }
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public static void main(String[] args) {
        Praktikum08_QueueCircular s = new Praktikum08_QueueCircular(10);
        s.Enqueue(10);
        s.Enqueue(20);
        s.Enqueue(30);
        s.Enqueue(40);

        s.printQueue();
//        s.Dequeue();
        s.Dequeue();
        s.printQueue();
    }
}
