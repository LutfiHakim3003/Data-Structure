class Node<T> {
  T key;
  Node? left, right;

  Node(this.key)
      : left = null,
        right = null;
}

class BinaryTree {
  Node? root;

  BinaryTree() {
    root = null;
  }

  void PreOrder(Node? node) {
    if (node != null) {
      print('${node.key}'); // root
      PreOrder(node.left); // subtree kiri
      PreOrder(node.right); // subtree kanan
    }
  }

  void PrintPreOrder() {
    PreOrder(root);
  }

  void InOrder(Node? node) {
    if (node != null) {
      InOrder(node.left); // subtree kiri
      print('${node.key}'); // root
      InOrder(node.right); // subtree kanan
    }
  }

  void PrintInOrder() {
    InOrder(root);
  }

  void InOrderIterative(Node? node) {
    if (root == null) return;

    List<Node> s = [];
    Node? curr = root;

    // Traverse the tree
    while (curr != null || s.isNotEmpty) {
      // Reach the left most Node of the curr Node
      while (curr != null) {
        // Place pointer to a tree node on the stack before traversing
        // the node's left subtree
        s.push(curr);
        curr = curr.left;
      }

      // Current must be null at this point
      curr = s.pop();

      print('${curr.key} ');

      // we have visited the node and its left subtree.
      // Now, it's right subtree's turn
      curr = curr.right;
    }
  }

  void PreOrderIterative(Node? node) {
    // Base Case
    if (node == null) {
      return;
    }

    // Create an empty stack and push root to it
    List<Node> nodeStack = [];
    nodeStack.push(node);

    /* Pop all items one by one. Do following for every popped item
     a) print it
     b) push its right child
     c) push its left child
     Note that right child is pushed first so that left is processed first */
    while (nodeStack.isNotEmpty) {
      // Pop the top item from stack and print it
      Node mynode = nodeStack.pop();
      print('${mynode.key} ');

      // Push right and left children of the popped node to stack
      if (mynode.right != null) {
        nodeStack.push(mynode.right!);
      }
      if (mynode.left != null) {
        nodeStack.push(mynode.left!);
      }
    }
  }

  void PostOrder(Node? node) {
    if (node != null) {
      PostOrder(node.left); // subtree kiri
      PostOrder(node.right); // subtree kanan
      print('${node.key}'); // root
    }
  }

  void PrintPostOrder() {
    PostOrder(root);
  }

  void PostOrderIterative(Node? node) {
    // Base Case
    if (node == null) {
      return;
    }

    // Create an empty stack and push root to it
    List<Node> nodeStack = [];
    nodeStack.push(node);

    /* Pop all items one by one. Do following for every popped item
     a) print it
     b) push its right child
     c) push its left child
     Note that right child is pushed first so that left is processed first */
    while (nodeStack.isNotEmpty) {
      // Pop the top item from stack and print it
      Node mynode = nodeStack.pop();
      // Push right and left children of the popped node to stack
      if (mynode.right != null) {
        nodeStack.push(mynode.right!);
      }
      if (mynode.left != null) {
        nodeStack.push(mynode.left!);
      }
      print('${mynode.key} ');
    }
  }
}

extension ListExtensions<T> on List<T> {
  void push(T element) => add(element);
  T pop() => removeLast();
  T peek() => this[lastIndex];
  int get lastIndex => length - 1;
}

void main() {
  BinaryTree tree = BinaryTree();
  tree.root = Node(1);
  tree.root!.left = Node("B");
  tree.root!.left!.left = Node(true);
  tree.root!.right = Node(5);
  tree.root!.left!.right = Node("C");
  tree.root!.right!.left = Node(10);

  print("Pre Order traversal of binary tree is: ");
  tree.PrintPreOrder();
  print("Iterative Pre Order traversal of binary tree is: ");
  tree.PreOrderIterative(tree.root);

  // print("In Order traversal of binary tree is: ");
  // tree.PrintInOrder();

  // print("Post Order traversal of binary tree is: ");
  // tree.PrintPostOrder();
}
