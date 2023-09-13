import java.util.Scanner;

public class Praktikum10_DoubleLinkedList4 {
    class Dnode {
        int nodeValue;
        Dnode prev, next;

        public Dnode(int data) {
            nodeValue = data;
            next = null;
            prev = null;
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

    // Penambahan node baru dan di depan node head
    public void push(int data) {
        Dnode new_node = new Dnode(data);
        if(isEmpty()) {
            head = new_node;
            head.prev = null;
            head.next = null;
        } else {
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
        }
    }

    public void InsertCustom(int position, int data) {
        Dnode new_node = new Dnode(data);
        if(isEmpty() || position == 0) {
            push(data);
        } else {
            // menambahkan node di tengah?
            Dnode temp = head;
            int count = 1;
            while(count < position && temp != null) {
                temp = temp.next;
                count++;
            }
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


    public void PrintList(Dnode node, int choice) {
        tail = null;
        if(choice == 1) {
            System.out.println("Forward Direction: ");
            while (node != null) {
                System.out.print(node.nodeValue + " ");
                tail = node;
                node = node.next;
            }
            System.out.println();
        } else if (choice == 2){
            System.out.println("Reversed Direction: ");
            while (node != null) {
                tail = node;
                node = node.next;
            }
            while(tail != null) {
                System.out.print(tail.nodeValue + " ");
                tail = tail.prev;
            }
        } else {
            System.out.println("Pilihan tidak ada!");
        }
    }

    public static void main(String[] args) {
        Praktikum10_DoubleLinkedList4 dll = new Praktikum10_DoubleLinkedList4();
        Scanner pilihan = new Scanner(System.in);
        dll.push(10);
        dll.push(20);
        dll.push(30);
        dll.InsertCustom(2, 25);

        System.out.println("Traversal in Double Linked List:");
        System.out.println("1. Forward Direction");
        System.out.println("2. Reversed Direction");
        System.out.println("Add Your Choice: ");
        int x = pilihan.nextInt();
        dll.PrintList(dll.head, x);

        System.out.println("\nData in Linked List After Delete Operation: ");
//        dll.deleteFront();
//        dll.deleteEnd();
        dll.deleteMiddle(25);
        dll.PrintList(dll.head, x);
    }
}
