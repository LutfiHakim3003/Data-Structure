import 'dart:io';

class Dnode {
  int nodeValue;
  Dnode? prev, next;

  Dnode(this.nodeValue)
      : prev = null,
        next = null;
}

class DoubleLinkedList {
  // Deklarasi Head dan Tail Node
  Dnode? head, tail;

  // Fungsi untuk kondisi kosong
  bool isEmpty() {
    return head == null;
  }

  // Menambahkan data baru atau di depan Head Node
  void insertFront(int data) {
    Dnode newNode = Dnode(data);
    if (isEmpty()) {
      head = newNode;
      head!.prev = null;
      head!.next = null;
    } else {
      newNode.next = head;
      head!.prev = newNode;
      head = newNode;
    }
  }

  // Menambahkan data baru atau di belakgn tail node
  void insertBack(int data) {
    Dnode newNode = Dnode(data);
    if (isEmpty()) {
      head = newNode;
      head!.next = null;
      head!.prev = null;
    } else {
      Dnode? temp = head;
      while (temp!.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
      newNode.prev = temp;
    }
  }

  void InsertCustom(Dnode temp, int data) {
    if (temp == isEmpty()) {
      print("Node tidak ditemukan");
    }
    Dnode newNode = new Dnode(data);
    newNode.next = temp.next;
    newNode.prev = temp;
    if (temp.next != null) {
      temp.next!.prev = newNode;
    } else {
      temp.next = newNode;
    }
    temp.next = newNode;
  }

  void PrintList(Dnode? node) {
    Dnode? tail;
    tail = null;
    print("Traversal in Forward Direction: ");
    while (node != null) {
      stdout.write("${node.nodeValue}, ");
      tail = node;
      node = node.next;
    }
    print(" ");
    print("Traversal in Reversed Direction: ");
    while (tail != null) {
      stdout.write("${tail.nodeValue}, ");
      tail = tail.prev;
    }
    print(" ");
  }
}

void main() {
  DoubleLinkedList Dll = DoubleLinkedList();

  Dll.insertFront(6);
  Dll.insertFront(10);
  Dll.insertBack(20);
  Dll.PrintList(Dll.head);

  Dll.InsertCustom(Dll.head!, 50);
  Dll.PrintList(Dll.head);
}
