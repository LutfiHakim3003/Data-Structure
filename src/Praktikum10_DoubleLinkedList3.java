public class Praktikum10_DoubleLinkedList3 {
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
        if (isEmpty()) {
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
            tail = head;
            while(tail.next != null) {
                tail = tail.next;
            }
            tail.next = new_node;
            new_node.prev = tail;
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
    public void PrintList(Dnode node) {
        tail = null;
        System.out.println("Forward Direction: ");
        while (node != null) {
            System.out.print(node.nodeValue + " ");
            tail = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Reversed Direction: ");
        while(tail != null) {
            System.out.print(tail.nodeValue + " ");
            tail = tail.prev;
        }
    }

    public static void main(String[] args) {
        Praktikum10_DoubleLinkedList3 dll = new Praktikum10_DoubleLinkedList3();

        dll.push(10);
        dll.push(20);
        dll.append(25);
        dll.InsertCustom(dll.head.next.next, 5);
        dll.PrintList(dll.head);
    }
}
