import 'dart:collection';

class Node<T> {
  int key;
  Node? left, right;

  Node(this.key)
      : left = null,
        right = null;
}

class BinaryTree<T> {
  Node? root;

  BinaryTree() {
    root = null;
  }

  // Traversal Binary Tree
  void printPreorder(Node? node) {
    if (node != null) {
      print('${node.key} ');
      printPreorder(node.left);
      printPreorder(node.right);
    }
  }

  void printPreorderFromRoot() {
    printPreorder(root);
  }

  void printInOrder(Node? node) {
    if (node != null) {
      printInOrder(node.left);
      print('${node.key} ');
      printInOrder(node.right);
    }
  }

  void printInOrderFromRoot() {
    printInOrder(root);
  }

  void printPostorder(Node? node) {
    if (node != null) {
      printPostorder(node.left);
      printPostorder(node.right);
      print('${node.key} ');
    }
  }

  void printPostorderFromRoot() {
    printPostorder(root);
  }

  // Print Level Order Traversal Binary Tree
  void printLevelOrder() {
    int h = height(root);
    for (int i = 0; i <= h; i++) {
      printCurrentLevel(root, i);
    }
  }

  int height(Node? root) {
    if (root == null) {
      return 0;
    } else {
      int lheight = height(root.left);
      int rheight = height(root.right);
      return lheight > rheight ? lheight + 1 : rheight + 1;
    }
  }

  void printCurrentLevel(Node? root, int level) {
    if (root != null) {
      if (level == 0) {
        print('${root.key} ');
      } else if (level >= 1) {
        printCurrentLevel(root.left, level - 1);
        printCurrentLevel(root.right, level - 1);
      }
    }
  }

  int maxDepth(Node? node) {
    if (node == null) {
      return 0;
    } else {
      int lDepth = maxDepth(node.left);
      int rDepth = maxDepth(node.right);
      return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
    }
  }

  void deleteDeepest(Node root, Node delNode) {
    Queue<Node> q = Queue();
    q.add(root); // enquee
    Node? temp;

    while (q.isNotEmpty) {
      temp = q.removeFirst(); // dequee
      if (temp == delNode) {
        temp = null;
        return;
      }

      if (temp.right != null) {
        if (temp.right == delNode) {
          temp.right = null;
          return;
        } else {
          q.add(temp.right!);
        }
      }

      if (temp.left != null) {
        if (temp.left == delNode) {
          temp.left = null;
          return;
        } else {
          q.add(temp.left!);
        }
      }
    }
  }

  void delete(Node? root, int key) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      if (root.key == key) {
        root = null;
      }
      return;
    }

    Queue<Node> q = Queue();
    q.add(root); // enquee
    Node? temp;
    Node? keyNode;

    while (q.isNotEmpty) {
      temp = q.removeFirst(); // dequee

      if (temp.key == key) {
        keyNode = temp;
      }

      if (temp.left != null) {
        q.add(temp.left!);
      }

      if (temp.right != null) {
        q.add(temp.right!);
      }
    }

    if (keyNode != null) {
      dynamic x = temp!.key;
      deleteDeepest(root, temp);
      keyNode.key = x;
    }
  }
}

void main() {
  BinaryTree tree = BinaryTree();
  tree.root = Node(13);
  tree.root!.left = Node(12);
  tree.root!.left!.left = Node(4);
  tree.root!.left!.right = Node(19);
  tree.root!.right = Node(10);
  tree.root!.right!.left = Node(16);
  tree.root!.right!.right = Node(9);

  // print("Pre Order traversal of binary tree is: ");
  // tree.printPreorderFromRoot();

  print("In Order traversal of binary tree is: ");
  tree.printInOrderFromRoot();

  // print("Post Order traversal of binary tree is: ");
  // tree.printPostorderFromRoot();

  // print("Height of Binary Tree: ${tree.maxDepth(tree.root)}");

  tree.delete(tree.root, 19);

  print("In Order traversal of binary tree is: ");
  tree.printInOrderFromRoot();

  // print("Nilai pada Level Tertentu pada Binary Tree: ");
  // tree.printCurrentLevel(tree.root, 1);

  // print("Height of Binary Tree: ${tree.maxDepth(tree.root)}");
}
