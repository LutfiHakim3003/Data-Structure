public class Praktikum07_Stack2 {
  int top;
  int maxStack;
  int[] elemen;

  public Praktikum07_Stack2(int maxElements) {
      this.top = -1;
      maxStack = maxElements - 1;
      elemen = new int[maxElements];
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

  public void push(int data) {
      if(isFull()) {
          System.out.println("Stack Overflow");
      } else {
          top = top + 1;
          elemen[top] = data;
      }
  }
  public int pop() {
      int data = 0;
      if(isEmpty()) {
          System.out.println("Stack Underflow");
      } else {
          data = elemen[top];
          elemen[top] = 0;
          top = top - 1;
      }
      return data;
  }

  public int peek() {
        if(isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return elemen[top];
        }
  }
  public void printStack() {
      if(!isEmpty()) {
          for(int i = top; i > -1; i--) {
              System.out.println("Elemen ke-"+ i + " = " + elemen[i]);
          }
      } else {
          System.out.println("Stack masih kosong!");
      }
  }

  public static void main(String[] args) {
      Praktikum07_Stack2 s = new Praktikum07_Stack2(10);
      s.push(10);
      s.push(20);
      s.push(30);
      s.push(40);
      s.push(50);
      System.out.println("Cetak data Stack dari urutan tertinggi:");
      s.printStack();

      System.out.println("Data setelah diambil:");
      s.pop();
      s.pop();
      s.printStack();

      System.out.println("Top of Stack: " + s.peek());
  }
}