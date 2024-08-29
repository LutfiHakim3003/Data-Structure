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
}

void main() {
  BinarySearchTree<int> bst = BinarySearchTree();

  bst.add(10);
  bst.add(7);
  bst.add(15);
  bst.add(8);
  bst.add(12);

  STNode<int>? rootNode = bst.getRoot();
  if (rootNode != null) {
    print('Root Value: ${rootNode.nodeValue}');
  } else {
    print('The tree is empty.');
  }

  print("In Order traversal of BST is: ");
  BinarySearchTree.InOrderDisplay(bst.getRoot());

  var node = bst.findNode(8);
  if (node != null) {
    print('Node found with value: ${node.nodeValue}');
  } else {
    print('Node not found.');
  }

  bool node2 = bst.find(5);
  if (node2) {
    print('Node found');
  } else {
    print('Node not found.');
  }
}
