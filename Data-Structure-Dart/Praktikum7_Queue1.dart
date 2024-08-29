class Queue {
  List<int> elements = [];
  int front = 0;
  int rear = 0;
  int maxQueue = 0;

  void QueueOperation(int max) {
    front = 0;
    rear = -1;
    elements = List<int>.filled(max, 0);
    maxQueue = max - 1;
  }

  bool isEmpty() {
    return rear == -1 && front == 0;
  }

  bool isFull() {
    return rear == maxQueue - 1;
  }

  void enqueue(int data) {
    if (isFull()) {
      print("Queue Overflow, tidak dapat mengisi data lagi");
    } else {
      rear = rear + 1;
      elements[rear] = data;
    }
  }

  int dequeue() {
    int data = 0;
    if (isEmpty()) {
      print("Queue Underflow");
      return -1;
    } else {
      data = elements[front];
      elements[front] = 0;
      // front += 1;
      if (front == rear) {
        front = -1;
        rear = -1;
      } else {
        front = (front + 1) % maxQueue;
      }
    }
    return data;
  }

  int dequeue2() {
    if (isEmpty()) {
      print("Queue Underflow");
      return -1; // Atau nilai yang sesuai untuk menunjukkan kegagalan dequeue
    } else {
      int data = elements[front];
      // Geser elemen ke depan untuk menutupi elemen yang dihapus
      for (int i = front; i < rear; i++) {
        elements[i] = elements[i + 1];
      }
      rear--; // Kurangi posisi rear karena satu elemen telah dihapus
      if (rear < 0) {
        // Reset rear jika tidak ada elemen lagi dalam antrian
        front = -1;
        rear = -1;
      }
      return data;
    }
  }

  int frontElement() {
    if (isEmpty()) {
      return -1;
    } else {
      return elements[front];
    }
  }

  int rearElement() {
    if (isEmpty()) {
      return -1;
    } else {
      return elements[rear];
    }
  }

  void printQueue() {
    if (!isEmpty()) {
      print("Menampilkan urutan dari posisi tertinggi");
      for (int i = rear; i > -1; i--) {
        print("Elemen ke-$i = ${elements[i]}");
      }
    } else {
      print("Queue masih kosong");
    }
  }
}

void main() {
  Queue q = Queue();
  q.QueueOperation(100);
  q.enqueue(10);
  q.enqueue(20);
  q.enqueue(30);

  q.printQueue();

  print('Front Elemen = ${q.frontElement()}');
  print('Rear Elemen = ${q.rearElement()}');
  q.dequeue2();
  // q.dequeue();
  // q.dequeue();
  // q.dequeue();
  q.printQueue();
  // print('Front Elemen = ${q.frontElement()}');
  // print('Rear Elemen = ${q.rearElement()}');
}
