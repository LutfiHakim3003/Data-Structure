class STNode<T> {
  T nodeValue;
  STNode<T>? left, right, parent;

  STNode(this.nodeValue, [this.parent]) {
    left = null;
    right = null;
  }

  STNode.withChildren(this.nodeValue, this.left, this.right) {
    parent = null;
  }
}

void main() {
  // Penerapan BST
  STNode<dynamic> node1 = STNode(1);
  STNode<dynamic> node2 = STNode("A", node1);
  STNode<dynamic> node3 = STNode.withChildren("B", node1, node2);

  print('Node 1: ${node1.nodeValue}');
  print('Node 2: ${node2.nodeValue}, Parent: ${node2.parent?.nodeValue}');
  print(
      'Node 3: ${node3.nodeValue}, Left: ${node3.left?.nodeValue}, Right: ${node3.right?.nodeValue}');
}
