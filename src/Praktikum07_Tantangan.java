public class Praktikum07_Tantangan {
    int top;
    int maxStack;
    String[] elemen;

    public Praktikum07_Tantangan(int maxElements) {
        this.top = -1;
        maxStack = maxElements - 1;
        elemen = new String[maxElements];
    }
    public boolean isEmpty() {
        boolean flag;
        if(top == -1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public boolean isFull() {
        boolean flag;
        if(top == maxStack) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void push(String data) {
        if(isFull()) {
            System.out.println("Stack condition is overflow");
        } else {
            top = top + 1;
            elemen[top] = data;
        }
    }
    public String pop() {
        String data = "";
        if(isEmpty()) {
            System.out.println("Stack condition is underflow");
        } else {
            data = elemen[top];
            elemen[top] = "";
            top = top - 1;
        }
        return data;
    }

    public void printStack() {
        if(!isEmpty()) {
            for (int i = top; i>-1; i--) {
                System.out.println("Elemen ke-" + i + " = " + elemen[i]);
            }
        } else {
            System.out.println("Stack masih kosong");
        }
    }

    public static void main(String[] args) {
        Praktikum07_Tantangan s = new Praktikum07_Tantangan(100);
        s.push("10");
        s.push("20");
        s.push("30");
        s.push("40");
        System.out.println("Menampilkan urutan dari posisi tertinggi: ");
        s.printStack();

        System.out.println();
        System.out.println("Stack after pop operation: ");
        s.pop();
        s.printStack();
    }
}
