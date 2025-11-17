import 'dart:collection';

class Node<T> {
  int key;
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

  void printLevelOrder() {
    int h = height(root);
    for (int i = 1; i <= h; i++) {
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
      if (level == 1) {
        print('${root.key} ');
      } else if (level > 1) {
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
    q.add(root);
    Node? temp;

    while (q.isNotEmpty) {
      temp = q.removeFirst();
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
    q.add(root);
    Node? temp;
    Node? keyNode;

    while (q.isNotEmpty) {
      temp = q.removeFirst();

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
      int x = temp!.key;
      deleteDeepest(root, temp);
      keyNode.key = x;
    }
  }
}

void main() {
  BinaryTree tree = BinaryTree();
  tree.root = Node(1);
  tree.root!.left = Node(2);
  tree.root!.right = Node(3);
  tree.root!.left!.left = Node(4);

  print("In Order traversal of binary tree is: ");
  tree.printInOrderFromRoot();

  tree.delete(tree.root, 3);

  print("\nInorder Traversal after deletion:");
  tree.printInOrderFromRoot();

  print("Height of Binary Tree: , ${tree.maxDepth(tree.root)}");
}
