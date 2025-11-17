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
      root = newNode;
    } else if (orderValue < 0) {
      parent.left = newNode;
    } else {
      parent.right = newNode;
    }
    treeSize++;
    return true;
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

  bool find(T item) {
    STNode<T>? t = findNode(item);

    if (t != null) {
      T value = t.nodeValue;
      return true;
    }
    return false;
  }

  STNode<T>? getRoot() {
    return root;
  }

  static InOrderDisplay<T>(STNode<T>? node) {
    if (node != null) {
      InOrderDisplay(node.left);
      print('${node.nodeValue}');
      InOrderDisplay(node.right);
    }
  }

  static PreOrderDisplay<T>(STNode<T>? node) {
    if (node != null) {
      print('${node.nodeValue}');
      PreOrderDisplay(node.left);
      PreOrderDisplay(node.right);
    }
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
  BinarySearchTree<dynamic> bst = BinarySearchTree();
  bst.add(10);
  bst.add(5);
  bst.add(15);

  // print('Tree Size: ${bst.treeSize}');

  // var node = bst.findNode(5);
  // if (node != null) {
  //   print('Node found with value: ${node.nodeValue}');
  // } else {
  //   print('Node not found.');
  // }

  // bool node = bst.find(5);
  // if (node) {
  //   print('Node found');
  // } else {
  //   print('Node not found.');
  // }
  STNode<dynamic>? rootNode = bst.getRoot();
  if (rootNode != null) {
    print('Root Value: ${rootNode.nodeValue}');
  } else {
    print('The tree is empty.');
  }

  STNode<dynamic>? nodeToRemove = bst.findNode(15);
  bst.RemoveNode(nodeToRemove);

  print('InOrder Display:');
  BinarySearchTree.InOrderDisplay(bst.getRoot());
}
