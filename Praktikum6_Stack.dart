import 'Praktikum6_Stack1.dart';

void main() {
  Stack s = Stack();
  s.StackOperation(100);
  s.push(10);
  s.push(20);
  s.push(30);
  s.push(50);
  s.push(5);

  s.printStack();

  print("Top of Stack: " + s.top().toString());

  s.pop();
  s.pop();
  s.printStack();
  print("Top of Stack: " + s.top().toString());
}
