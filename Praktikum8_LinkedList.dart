class Node {
  int nodeValue;
  Node? next;

  Node(this.nodeValue) : next = null;
}

class LinkedList {
  /* Untuk Single Linked List */
  Node? head = null;

  bool isEmpty() {
    return head == null;
  }

  void insertFront(int data) {
    Node baru = Node(data);
    if (isEmpty()) {
      head = baru;
    } else {
      baru.next = head;
      head = baru;
    }
  }

  void insertBack(int data) {
    Node baru = Node(data);
    if (isEmpty()) {
      head = baru;
    } else {
      Node? bantu = head;
      while (bantu!.next != null) {
        bantu = bantu.next;
      }
      bantu.next = baru;
    }
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

  void printList() {
    if (!isEmpty()) {
      Node? sekarang = head;
      while (sekarang != null) {
        print('${sekarang.nodeValue} ');
        sekarang = sekarang.next;
      }
    } else {
      print('List dalam kondisi kosong');
    }
  }
}

void main() {
  LinkedList linkedList = LinkedList();

  // Menambahkan elemen ke linked list
  linkedList.insertBack(10);
  linkedList.insertBack(20);
  linkedList.insertBack(30);

  // Menampilkan isi linked list
  linkedList.printList();

  // Menghapus elemen pertama
  linkedList.deleteFront();

  // Menampilkan isi linked list setelah penghapusan
  linkedList.printList();
}
