class STNode<T> {
  T nodeValue;
  STNode<T>? left, right, parent;

  STNode(this.nodeValue, [this.parent]) {
    left = null;
    right = null;
  }
}

class BinarySearchTree<T extends Comparable> {
  STNode<T>? root;
  int treeSize = 0;

  BinarySearchTree() {
    root = null;
  }

  bool add(T item) {
    STNode<T>? t = root, parent;
    int orderValue = 0;

    while (t != null) {
      parent = t;
      orderValue = item.compareTo(t.nodeValue);

      if (orderValue == 0) {
        return false;
      } else if (orderValue < 0) {
        t = t.left;
      } else {
        t = t.right;
      }
    }

    STNode<T> newNode = STNode(item, parent);
    if (parent == null) {
      root = newNode; // tree tidak ada nilai
    } else if (orderValue < 0) {
      parent.left = newNode; // Tambah Nilai pada subtree kiri
    } else {
      parent.right = newNode; // Tambah nilai pada subtree kanan
    }
    treeSize++;
    return true;
  }

  STNode<T>? getRoot() {
    return root;
  }

  static PreOrderDisplay<T>(STNode<T>? node) {
    if (node != null) {
      print('${node.nodeValue}');
      PreOrderDisplay(node.left);
      PreOrderDisplay(node.right);
    }
  }

  static InOrderDisplay<T>(STNode<T>? node) {
    if (node != null) {
      InOrderDisplay(node.left);
      print('${node.nodeValue}');
      InOrderDisplay(node.right);
    }
  }

  static PostOrderDisplay<T>(STNode<T>? node) {
    if (node != null) {
      InOrderDisplay(node.left);
      InOrderDisplay(node.right);
      print('${node.nodeValue}');
    }
  }

  STNode<T>? findNode(T item) {
    STNode<T>? t = root;
    int orderValue = 0;

    while (t != null) {
      orderValue = item.compareTo(t.nodeValue);

      if (orderValue == 0) {
        return t;
      } else if (orderValue < 0) {
        t = t.left;
      } else {
        t = t.right;
      }
    }
    return null;
  }

  void RemoveNode(STNode<T>? dNode) {
    if (dNode == null) {
      return;
    }
    STNode<T>? pNode, rNode;
    pNode = dNode.parent;
    // Node yang dihapus mempunyai satu anak
    if (dNode.left == null || dNode.right == null) {
      if (dNode.right == null) {
        rNode = dNode.left;
      } else {
        rNode = dNode.left;
      }

      if (rNode != null) {
        print("Ngeset Parent");
        rNode.parent = pNode;
      }
      // Menghapus node root
      if (pNode == null) {
        root = rNode;
      } else if ((dNode.nodeValue as Comparable<T>).compareTo(pNode.nodeValue) <
          0) {
        pNode.left = rNode;
      } else {
        pNode.right = rNode;
      }
    } // Node yang dihapus mempunyai dua anak
    else {
      STNode<T>? pOfRNode = dNode;
      rNode = dNode.right;
      pOfRNode = dNode;

      while (rNode!.left != null) {
        pOfRNode = rNode;
        rNode = rNode.left;
      }
      dNode.nodeValue = rNode.nodeValue;
      if (pOfRNode == dNode) {
        dNode.right = rNode.right;
      } else {
        pOfRNode!.left = rNode.right;
      }

      if (rNode.right != null) {
        rNode.right!.parent = pOfRNode;
      }
    }
  }
}

void main() {
  BinarySearchTree<dynamic> t = BinarySearchTree();
  t.add(5);
  t.add(3);
  t.add(10);
  t.add(12);
  t.add(7);

  STNode<dynamic>? rootNode = t.getRoot();
  if (rootNode != null) {
    print('Root Value: ${rootNode.nodeValue}');
  } else {
    print("Tree is Empty.");
  }

  print('Pre Order traversal of BST is: ');
  BinarySearchTree.PreOrderDisplay(t.getRoot());

  // print('In Order traversal of BST is: ');
  // BinarySearchTree.InOrderDisplay(t.getRoot());

  // print('Post Order traversal of BST is: ');
  // BinarySearchTree.PostOrderDisplay(t.getRoot());

  // var node = t.findNode(12);
  // if (node != null) {
  //   print('Nilai yang dicari: ${node.nodeValue}');
  // } else {
  //   print('Node not found.');
  // }

  STNode<dynamic>? nodeToRemove = t.findNode(12);
  t.RemoveNode(nodeToRemove);

  print('Pre Order traversal of BST is: ');
  BinarySearchTree.PreOrderDisplay(t.getRoot());
}
