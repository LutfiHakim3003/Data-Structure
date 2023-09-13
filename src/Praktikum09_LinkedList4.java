public class Praktikum09_LinkedList4 {
    class Node {
        int nodeValue;
        Node next;

        public Node(int data1) {
            nodeValue = data1;
            next = null;
        }
    }
    Node head;

    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }
     public void push(int data) {
        Node baru = new Node(data);
        if(isEmpty()) {
            head = baru;
            head.next = null;
        } else {
            baru.next = head;
            head = baru;
        }
    }
    public void InsertBack(int data) {
        Node baru = new Node(data);
        if(isEmpty()) {
            head = baru;
            head.next = null;
        } else {
            Node bantu;
            bantu = head;
            while (bantu.next != null) {
                bantu = bantu.next;
            }
            bantu.next = baru;
        }
    }

    public void InsertCustom(Node bantu, int data) {
        Node baru = new Node(data);
        if(isEmpty()) {
            head = baru;
            head.next = null;
        } else {
            if(bantu == null) {
                System.out.println("The given previous node cannot be null");
            } else {
                baru.next = bantu.next;
                bantu.next = baru;
            }
        }
    }
    public Node findNode(int data) {
        Node hasil = null;
        Node sekarang = head;
        while(sekarang.nodeValue != data){
            sekarang = sekarang.next;
        }
        hasil = sekarang;
        return hasil;
    }

    public void deleteFront() {
        Node hapus;
        if(!isEmpty()) {
            if(head.next != null) {
                hapus = head;
                head = head.next;
            } else {
                head = null;
            }
        }
    }

    public void deleteEnd() {
        Node bantu;
        if(!isEmpty()) {
            if(head.next != null) {
                bantu = head;
                while(bantu.next.next != null){
                    bantu = bantu.next;
                }
                bantu.next = null;
            } else {
                head = null;
            }
        }
    }

    public void deleteMiddle(int cari) {
        Node bantu, hapus;
        if(!isEmpty()) {
            if(head.next != null) {
                bantu = head;
                while(bantu.next.nodeValue != cari){
                    bantu = bantu.next;
                }
                hapus = bantu.next;
                bantu.next = hapus.next;
                hapus.next = null;
            } else {
                head = null;
            }
        }
    }

    public void printList() {
        if(!isEmpty()) {
            Node now = head;
            while (now != null) {
                System.out.print(now.nodeValue + " ");
                now = now.next;
            }
        } else {
            System.out.println("Linked List is Empty");
        }
    }

    public static void main(String[] args) {
        Praktikum09_LinkedList4 ll = new Praktikum09_LinkedList4();

        ll.push(10);
        ll.push(20);
        ll.push(30);
        System.out.println("Data of Linked List: ");
        ll.printList();

        ll.InsertBack(40);
        System.out.println("\nData after Insert Back: ");
        ll.printList();

        System.out.println("\nData after Insert Custom: ");
        ll.InsertCustom(ll.head.next.next.next, 35);
        ll.printList();

        System.out.println("\nDelete of Linked List: ");
//        ll.deleteFront();
//        ll.deleteEnd();
        ll.deleteMiddle(10);
        ll.printList();
//        System.out.println("\nFind node: " + ll.findNode(30));
    }
}