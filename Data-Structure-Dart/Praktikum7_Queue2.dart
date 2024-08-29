// Queue pada Circular Array (Array seperti lingkaran)
class Queue {
  List<int> element = [];
  int front = 0;
  int rear = 0;
  int maxQueue = 0;

  void QueueOperation(int max) {
    front = 0;
    rear = -1;
    element = List<int>.filled(max, 0);
    maxQueue = max - 1;
  }

  bool isEmpty() {
    return rear == -1 && front == 0;
  }

  bool isFull() {
    bool flag = true;
    for (int i = 0; i <= maxQueue; i++) {
      if (element[i] == 0) {
        flag = false;
        break;
      }
    }
    return flag;
  }

  void enqueue(int data) {
    if (isFull()) {
      print("Queue Overflow, tidak dapat mengisi data lagi");
    } else {
      if (rear != maxQueue) {
        rear += 1;
      } else {
        rear = 0;
      }
      element[rear] = data;
    }
  }

  int dequeue() {
    int data = 0;
    if (isEmpty()) {
      print("Queue Underflow");
    } else {
      data = element[front];
      element[front] = 0;
      if (front == maxQueue) {
        front = 0;
      } else {
        front += 1;
      }
    }
    return data;
  }

  int dequeue2() {
    int data = 0;
    if (isEmpty()) {
      print("Queue Underflow");
    } else {
      data = element[front];
      for (int i = front; i < rear; i++) {
        element[i] = element[i + 1];
      }
      rear--;
      if (rear < 0) {
        front = -1;
        rear = -1;
      }

      if (front == maxQueue) {
        front = 0;
      } else {
        front += 1;
      }
    }
    return data;
  }

  void printQueue() {
    if (!isEmpty()) {
      print("Menampilkan urutan dari posisi tertinggi");
      for (int i = rear; i > -1; i--) {
        print("Elemen ke-$i = ${element[i]}");
      }
    } else {
      print("Queue masih kosong");
    }
  }
}
