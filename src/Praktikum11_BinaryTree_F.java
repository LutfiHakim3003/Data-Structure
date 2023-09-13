import java.util.LinkedList;
import java.util.Queue;

public class Praktikum11_BinaryTree_F {
    static class Node {
        int key;
        Node right, left;
        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;

    Praktikum11_BinaryTree_F() {
        root = null;
    }

    void PrintPreeorder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.key + " ");
        PrintPreeorder(node.left);
        PrintPreeorder(node.right);
    }
    void PrintPreorder() {
        PrintPreeorder(root);
    }

    void PrintInorder(Node node) {
        if(node == null) {
            return;
        }
        PrintInorder(node.left);
        System.out.print(node.key + " ");
        PrintInorder(node.right);
    }
    void PrintInorder() {
        PrintInorder(root);
    }

    void PrintPostorder(Node node) {
        if(node == null) {
            return;
        }
        PrintPostorder(node.left);
        PrintPostorder(node.right);
        System.out.print(node.key + " ");
    }
    void PrintPostorder() {
        PrintPostorder(root);
    }
    int MaxDepth(Node node) {
        if(node == null) {
            return 0;
        } else {
            int lDepth = MaxDepth(node.left);
            int rDepth = MaxDepth(node.right);

            if(lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }
    int MaxDepth() {
        return MaxDepth(root);
    }

    void DeleteDeepest(Node root, Node delNode) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;

        while(!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if(temp == delNode) {
                temp = null;
                return;
            }
            if(temp.right != null) {
                if(temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }
            if(temp.right != null) {
                if(temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }
    void delete(Node root, int key) {
        if(root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if(root.key == key) {
                root = null;
                return;
            } else {
                return;
            }
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;

        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if(temp.key == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
            if(keyNode != null) {
                int x = temp.key;
                DeleteDeepest(root, temp);
                keyNode.key = x;
            }
        }
    }
    void delete(int item){
        delete(root, item);
    }

    public static void main(String[] args) {
        Praktikum11_BinaryTree_F tree = new Praktikum11_BinaryTree_F();

        tree.root = new Node(5);
        tree.root.left = new Node(10);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(25);

//        System.out.println("Preorder Traversal Binary Tree:");
//        tree.PrintPreorder();
        System.out.println("Inorder Traversal Binary Tree:");
        tree.PrintInorder();
//        System.out.println("Postorder Traversal Binary Tree:");
//        tree.PrintPostorder();

//        System.out.println("Height of Binary Tree: " + tree.MaxDepth());
        tree.delete(20);
        System.out.println("\nBinary Tree after delete:");
        tree.PrintPreorder();
    }
}
