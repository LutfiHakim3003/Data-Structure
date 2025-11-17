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

  // Traversal Pre Order
  void PreOrder(Node? node) {
    if (node != null) {
      print('${node.key}');
      PreOrder(node.left);
      PreOrder(node.right);
    }
  }

  void PrintPreOrder() {
    PreOrder(root);
  }

  // Traversal InOrder
  void InOrder(Node? node) {
    if (node != null) {
      InOrder(node.left);
      print('${node.key}');
      InOrder(node.right);
    }
  }

  void PrintInOrder() {
    InOrder(root);
  }

  // Traversal InOrder
  void PostOrder(Node? node) {
    if (node != null) {
      InOrder(node.left);
      InOrder(node.right);
      print('${node.key}');
    }
  }

  void PrintPostOrder() {
    PostOrder(root);
  }
}

void main() {
  BinaryTree tree = BinaryTree();
  tree.root = Node("A");
  tree.root!.left = Node(5);
  tree.root!.right = Node(10);
  tree.root!.left!.right = Node(7);
  tree.root!.right!.left = Node(3);

  print("Pre Order Traversal of Binary Tree: ");
  tree.PrintPreOrder();

  print("In Order Traversal of Binary Tree: ");
  tree.PrintInOrder();

  print("Post Order Traversal of Binary Tree: ");
  tree.PrintPostOrder();
}
