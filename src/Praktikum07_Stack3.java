import java.util.Stack;

public class Praktikum07_Stack3 {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(false);
        s.push(1);
        s.push("b");

        System.out.println(s);
        System.out.println("Top of Stack: " + s.peek());
        System.out.println("Delete data: " + s.pop());
        System.out.println(s);
    }
}
