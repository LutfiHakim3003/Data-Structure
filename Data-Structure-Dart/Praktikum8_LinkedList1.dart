class Node {
  int nodeValue;
  Node? next;

  Node(this.nodeValue) : next = null;
}

class LinkedList {
  /* Single Linked List */
  Node? head = null;

  bool isEmpty() {
    return head == null;
  }

  void InsertFront(int data) {
    Node newNode = Node(data);
    if (isEmpty()) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  void InsertBack(int data) {
    Node newNode = Node(data);
    if (isEmpty()) {
      head = newNode;
    } else {
      Node? temp = head;
      while (temp!.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  void InsertAfter(Node prevNode, int newData) {
    if (prevNode == isEmpty()) {
      print("The given previous node cannot be null");
    }
    Node newNode = Node(newData);
    newNode.next = prevNode.next;
    prevNode.next = newNode;
  }

  Node? findNode(int data) {
    Node? hasil;
    Node? sekarang = head;
    while (sekarang != null) {
      if (sekarang.nodeValue == data) {
        hasil = sekarang;
        break;
      }
      sekarang = sekarang.next;
    }
    return hasil;
  }

  void deleteFront() {
    if (!isEmpty()) {
      if (head!.next != null) {
        head = head!.next;
      } else {
        head = null;
      }
    }
  }

  void deleteEnd() {
    if (!isEmpty()) {
      if (head!.next != null) {
        Node? bantu = head;
        while (bantu!.next!.next != null) {
          bantu = bantu.next;
        }
        bantu.next = null;
      } else {
        head = null;
      }
    }
  }

  void deleteMiddle(int cari) {
    if (!isEmpty()) {
      if (head!.next != null) {
        Node? bantu = head;
        while (bantu!.next!.nodeValue != cari) {
          bantu = bantu.next;
        }
        Node? hapus = bantu.next;
        bantu.next = hapus!.next;
        hapus.next = null;
      } else {
        head = null;
      }
    }
  }

  void PrintList() {
    if (!isEmpty()) {
      Node? now = head;
      while (now != null) {
        print('${now.nodeValue} ');
        now = now.next;
      }
    } else {
      print('List dalam kondisi kosong');
    }
  }
}

void main() {
  LinkedList ll = LinkedList();

  print("Data:");
  ll.InsertBack(10);
  ll.InsertBack(20);

  ll.PrintList();

  ll.InsertFront(50);

  print("Tambah Data di Depan Head:");
  ll.PrintList();

  print('Penyisipan Data');
  ll.InsertAfter(ll.head!.next!.next!, 30);
  ll.PrintList();

  print("Operasi Penghapusan data:");
  ll.deleteMiddle(10);
  ll.PrintList();
}
