import java.util.Scanner;

public class Praktikum10_DoubleLinkedList2 {
    class Dnode {
        int nodeValue;
        Dnode prev, next;

        public Dnode(int data) {
            nodeValue = data;
            prev = null;
            next = null;
        }
    }
    Dnode head, tail;

    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        Dnode new_node = new Dnode(data);

        if(isEmpty()) {
            head = new_node;
            head.next = null;
            head.prev = null;
        } else {
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
        }
    }

    public void append(int data) {
        Dnode new_node = new Dnode((data));
        if(isEmpty()) {
            head = new_node;
            head.next = null;
            head.prev = null;
        } else {
            Dnode temp;
            temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.prev = temp;
        }
    }

    public void InsertCustom(Dnode temp, int data) {
        Dnode new_node = new Dnode(data);
        if(isEmpty()) {
            push(data);
        } else {
            if(temp == null) {
                System.out.println("The given previous node cannot be null");
            } else {
                new_node.prev = temp.prev;
                temp.prev = new_node;
                new_node.next = temp;

                if(new_node.prev != null) {
                    new_node.prev.next = new_node;
                } else {
                    head = new_node;
                }
            }
        }
    }
    public void ForwardDirection(Dnode node) {
        tail = null;
        System.out.println("Traversal in Forward Direction:");
        if(!isEmpty()) {
            while (node != null) {
                System.out.print(node.nodeValue + " ");
                tail = node;
                node = node.next;
            }
        } else {
            System.out.println("Linked List is Empty");
        }
    }

    public void deleteFront() {
        Dnode hapus;
        if(!isEmpty()) {
            if(head.next != null) {
                hapus = head;
                head = head.next;
                head.prev = null;
            } else {
                head = null;
            }
        }
    }
    public void deleteEnd() {
        Dnode bantu;
        if(!isEmpty()) {
            if(head.next != null) {
                bantu = head;
                while(bantu.next.next != null){
                    bantu = bantu.next;
                }
                bantu.next.prev = null;
                bantu.next = null;
            } else {
                head = null;
            }
        }
    }
    public void deleteMiddle(int cari) {
        Dnode bantu, hapus;
        if(!isEmpty()) {
            if(head.next != null) {
                bantu = head;
                while(bantu.next.nodeValue != cari){
                    bantu = bantu.next;
                }
                hapus = bantu.next;
                bantu.next = hapus.next;
                hapus.next.prev = bantu;
            } else {
                head = null;
            }
        }
    }


    public void ReversedDirection(Dnode node) {
        tail = null;
        System.out.println("Traversal in Reverse Direction: ");
        if(!isEmpty()) {
            while (node != null) {
                tail = node;
                node = node.next;
            }
            while (tail != null) {
                System.out.print(tail.nodeValue + " ");
                tail = tail.prev;
            }
        } else {
            System.out.println("Linked list is empty");
        }
    }
    public void printList(Dnode node) {
        tail = null;
        System.out.println("Traversal in Forward Direction: ");
        while (node != null) {
            System.out.print(node.nodeValue + " ");
            tail = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in Reverse Direction: ");
        while(tail != null) {
            System.out.print(tail.nodeValue + " ");
            tail = tail.prev;
        }
    }

    public static void main(String[] args) {
        Praktikum10_DoubleLinkedList2 dll = new Praktikum10_DoubleLinkedList2();

        Scanner pilihan = new Scanner(System.in);

        dll.push(10);
        dll.push(20);
        dll.append(40);
        dll.InsertCustom(dll.head.next.next, 65);
        dll.deleteMiddle(10);

        System.out.println("Proses Pembacaan Double Linked List:");
        System.out.println("1. Forward Direction");
        System.out.println("2. Reversed Direction");
        System.out.println("Masukkan pilihan: ");
        int x = pilihan.nextInt();

        if(x == 1) {
            dll.ForwardDirection(dll.head);
        } else if(x == 2) {
            dll.ReversedDirection(dll.head);
        } else {
            System.out.print("Pilihan hanya 1 & 2");
        }
//        dll.printList(dll.head);
    }
}
