public class Praktikum09_LinkedList2 {
    Node head;
    public Praktikum09_LinkedList2() {
        head = null;
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertFront(int data) {
        Node baru = new Node(data);
        if(isEmpty()) {
            head = baru;
            head.next = null;
        } else {
            baru.next = head;
            head = baru;
        }
    }

    public void insertBack(int data) {
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

    public void  deleteEnd() {
        Node bantu;
        if(!isEmpty()) {
            if(head.next != null) {
                bantu = head;
                while (bantu.next.next != null) {
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
                while(bantu.next.nodeValue != cari) {
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

    public Node findNode(int data) {
        Node hasil = null;
        Node sekarang = head;
        while (sekarang.nodeValue != data) {
            sekarang = sekarang.next;
        }
        hasil = sekarang;
        return hasil;
    }
    public void printList() {
        if(!isEmpty()) {
            Node sekarang = head;
            while(sekarang != null) {
                System.out.print(sekarang.nodeValue + " ");
                sekarang = sekarang.next;
            }
        } else {
            System.out.println("List dalam kondisi kosong");
        }
    }

    public static void main(String[] args) {
        Praktikum09_LinkedList2 llist = new Praktikum09_LinkedList2();

        llist.insertFront(10);
        llist.insertFront(20);

        System.out.println("\nData of Linked list: ");
        llist.printList();

        llist.insertBack(40);
        llist.insertBack(30);
        llist.insertBack(50);
        System.out.println("\nInsert Back of Linked list: ");
        llist.printList();

        llist.deleteFront();
        System.out.println("\nData After Operation of Delete Front: ");
        llist.printList();

        llist.deleteEnd();
        System.out.println("\nData After Operation of Delete End: ");
        llist.printList();

        llist.deleteMiddle(40);
        System.out.println("\nData After Operation of Delete Middle: ");
        llist.printList();

        System.out.println("\nData yang dicari: " + llist.findNode(40));
    }
}