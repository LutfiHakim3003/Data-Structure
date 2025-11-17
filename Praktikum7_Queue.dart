import 'Praktikum7_Queue2.dart';

void main() {
  Queue q = Queue();
  q.QueueOperation(100);
  q.enqueue(10);
  q.enqueue(20);
  q.enqueue(30);
  q.printQueue();

  // q.dequeue2();
  // q.dequeue2();
  q.dequeue();
  q.dequeue();
  q.printQueue();
}
