public class Praktikum09_LinkedList5 {
    class Node {
        int nodeValue;
        Node next;
        public Node(int data) {
            nodeValue = data;
            next = null;
        }
    }
    Node head;

    public boolean isEmpty() {
        if(head == null){
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        Node new_node = new Node(data);
        if(isEmpty()) {
            head = new_node;
            head.next = null;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }

    public void append(int data) {
        Node new_node = new Node(data);
        if(isEmpty()) {
            head = new_node;
            head.next = null;
        } else {
            Node temp;
            temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    public void insertAfter(Node temp, int data) {
        Node new_node = new Node(data);
        if(isEmpty()) {
            head = new_node;
            head.next = null;
        } else {
            if(temp == null) {
                System.out.println("The given previous node cannot be null");
            } else {
                new_node.next = temp.next;
                temp.next = new_node;
            }
        }
    }

    public void insertCustom(int data, int position) {
        Node baru = new Node(data);
        if (isEmpty() || position == 1) {
            push(data);
        } else {
            Node bantu = head;
            int counter = 1;
            while(bantu != null && counter < position - 1) {
                bantu = bantu.next;
                counter++;
            }
            baru.next = bantu.next;
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
            Node now_node = head;
            while (now_node != null) {
                System.out.print(now_node.nodeValue + " ");
                now_node = now_node.next;
            }
        } else {
            System.out.println("Linked List is Empty");
        }
    }

    public static void main(String[] args) {
        Praktikum09_LinkedList5 ll = new Praktikum09_LinkedList5();
        System.out.println("Data of Linked List: ");
        ll.push(10);
        ll.push(20);
        ll.push(30);
        ll.printList();

        System.out.println("\nData after insert custom: ");
        ll.insertCustom(6, 1);
        ll.printList();

        System.out.println("\nLinked List after Deleted data:");
        ll.deleteMiddle(10);
        ll.printList();
//        ll.append(40);
//        System.out.println("\nData after insert back: ");
//        ll.printList();
//
//        ll.insertAfter(ll.head.next.next, 5);
//        System.out.println("\nData insert after: ");
//        ll.printList();
    }
}
