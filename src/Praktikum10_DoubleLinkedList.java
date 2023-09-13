public class Praktikum10_DoubleLinkedList {
    class Dnode {
        int nodeValue;
        Dnode next, prev;
        public Dnode(int data) {
            nodeValue = data;
            next = null;
            prev = null;
        }
    }
    Dnode head;

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
        Dnode new_node = new Dnode(data);
        if(isEmpty()) {
            head = new_node;
            head.next = null;
            head.prev = null;
        } else {
            Dnode temp;
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.prev = temp;
        }
    }
    public void printList(Dnode node) {
        Dnode tail = null;
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
        Praktikum10_DoubleLinkedList dll = new Praktikum10_DoubleLinkedList();

        dll.push(10);
        dll.push(20);
        dll.push(30);
        System.out.println("Data Linked List: ");
        dll.printList(dll.head);

        dll.append(35);
        dll.append(40);
        System.out.println("\nAdded data from back of list: ");
        dll.printList(dll.head);
    }
}
