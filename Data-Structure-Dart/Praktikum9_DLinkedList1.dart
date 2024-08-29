import 'dart:io';

class Dnode<T> {
  T nodeValue;
  Dnode? next, prev;

  Dnode(this.nodeValue)
      : next = null,
        prev = null;
}

class DoubleLinkedList {
  Dnode? head, tail;

  bool isEmpty() {
    return head == null;
  }

  // Menambahkan Node baru
  void append(dynamic data) {
    Dnode newNode = Dnode(data);
    if (isEmpty()) {
      head = newNode;
      head!.prev = null;
      head!.next = null;
    } else {
      print("Data sudah ada pada Linekd List!");
    }
  }

  //Menambahkan Data sebelum head
  void InsertBeforeHead(dynamic data) {
    Dnode baru = Dnode(data);
    if (isEmpty()) {
      append(data);
    } else {
      baru.next = head;
      head!.prev = baru;
      head = baru;
    }
  }

  // menambahkan data baru atau di akhir node
  void InsertTailNode(dynamic data) {
    Dnode baru = Dnode(data);
    if (isEmpty()) {
      append(data);
    } else {
      Dnode? bantu = head;
      while (bantu!.next != null) {
        bantu = bantu.next;
      }
      bantu.next = baru;
      baru.prev = bantu;
    }
  }

  void InsertCustom(Dnode temp, dynamic data) {
    if (temp == isEmpty()) {
      print("Node dengan tidak ditemukan.");
    }
    Dnode baru = new Dnode(data);
    baru.next = temp.next;
    baru.prev = temp;
    if (temp.next != null) {
      temp.next!.prev = baru;
    } else {
      temp.next = baru;
    }
    temp.next = baru;
  }

  // void insertAfter(int key, int data) {
  //   Dnode? temp = findNode(key);
  //   if (temp == null) {
  //     print("Node dengan nilai $key tidak ditemukan.");
  //   } else {
  //     Dnode baru = new Dnode(data);
  //     baru.next = temp.next;
  //     baru.prev = temp;
  //     if (temp.next != null) {
  //       temp.next!.prev = baru;
  //     } else {
  //       temp.next = baru;
  //     }
  //     temp.next = baru;
  //   }
  // }

  void DeleteFront() {
    if (!isEmpty()) {
      if (head!.next != null) {
        Dnode? hapus = head;
        head = head!.next;
        head!.prev = null;
        hapus!.next = null;
      } else {
        head = null;
      }
    }
  }

  void DeleteEnd() {
    Dnode? bantu;
    if (!isEmpty()) {
      if (head!.next != null) {
        bantu = head;
        while (bantu!.next!.next != null) {
          bantu = bantu.next;
        }
        bantu.next!.prev = null;
        bantu.next = null;
      } else {
        head = null;
      }
    }
  }

  void DeleteNodeCustom(dynamic data) {
    Dnode? curr = head;

    // Jika node yang akan dihapus adalah node pertama
    if (curr != null && curr.nodeValue == data) {
      head = curr.next;
      if (head != null) {
        head!.prev = null;
      }
      print("Node dengan nilai $data berhasil dihapus.");
      return;
    }

    // Jika node yang akan dihapus bukan node pertama
    while (curr != null && curr.nodeValue != data) {
      curr = curr.next;
    }

    // Jika node dengan nilai data ditemukan
    if (curr != null) {
      if (curr.prev != null) {
        curr.prev!.next = curr.next;
      } else if (curr.next != null) {
        curr.next!.prev = curr.prev;
      }
      print("Node dengan nilai $data berhasil dihapus.");
    } else {
      // Jika node dengan nilai data tidak ditemukan
      print("Node dengan nilai $data tidak ditemukan dalam linked list.");
    }
  }

  Dnode? findNode(dynamic data) {
    Dnode? current = head;
    int index = 1;
    while (current != null) {
      if (current.nodeValue == data) {
        print("Node dengan nilai $data ditemukan pada indeks ke-$index.");
        return current;
      }
      current = current.next;
      index++;
    }
    // Jika node tidak ditemukan
    print("Node dengan nilai $data tidak ditemukan dalam linked list.");
    return null;
  }

  Dnode? findNodeByIndex(int index) {
    if (index < 0) {
      print("Indeks tidak valid.");
      return null;
    }

    int currentIndex = 0;
    Dnode? current = head;
    while (current != null) {
      if (currentIndex == index) {
        return current;
      }
      current = current.next;
      currentIndex++;
    }

    // Jika perulangan selesai dan indeks tidak ditemukan, kembalikan null
    print("Indeks tidak ditemukan.");
    return null;
  }

  void printList(Dnode? node) {
    Dnode? tail;
    tail = null;
    print("Traversal in Forward Direction: ");
    while (node != null) {
      stdout.write("${node.nodeValue} ");
      tail = node;
      node = node.next;
    }
    print("");
    print("Traversal in Reverse Direction: ");
    while (tail != null) {
      stdout.write("${tail.nodeValue} ");
      tail = tail.prev;
    }
    print("");
  }
}

void main() {
  DoubleLinkedList Dll = DoubleLinkedList();

  Dll.append(10);
  Dll.InsertBeforeHead("Lutfi");
  Dll.InsertTailNode(40);
  Dll.printList(Dll.head);

  Dll.InsertCustom(Dll.head!, 20);

  // Dll.DeleteNodeCustom(10);
  Dll.printList(Dll.head);

  // Cari node pada indeks tertentu
  int indexToFind = 2;
  Dnode? foundNode = Dll.findNodeByIndex(indexToFind);
  if (foundNode != null) {
    print("Node pada indeks $indexToFind: ${foundNode.nodeValue}");
  } else {
    print("Tidak ada node pada indeks $indexToFind.");
  }

  Dll.findNode(40);
}
