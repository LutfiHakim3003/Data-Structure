import java.util.LinkedList;
import java.util.Queue;

public class Praktikum11_BinaryTree {
    static class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;
    Praktikum11_BinaryTree() {
        root = null;
    }

    // Traversal Preorder
    void PrintPreorder(Node node) {
        if(node == null) {
            return;
        }

        System.out.print(node.key + " ");
        PrintPreorder(node.left);
        PrintPreorder(node.right);
    }
    void PrintPreorder() { PrintPreorder(root); }

    void PrintInOrder(Node node) {
        if(node == null) {
            return;
        }
        PrintInOrder(node.left);
        System.out.print(node.key + " ");
        PrintInOrder(node.right);
    }
    void PrintInOrder() {
        PrintInOrder(root);
    }

    void PrintPostorder(Node node) {
        if(node == null) {
            return;
        }
        PrintPostorder(node.left);
        PrintPostorder(node.right);

        System.out.print(node.key + " ");
    }
    void PrintPostorder() { PrintPostorder(root); }

    // Print Level Order of binary tree
    void PrintLevelOrder() {
        int h = height(root);
        for(int i = 1; i <= h; i++) {
            PrintCurrentLevel(root, i);
        }
    }
    int height(Node root) {
        if(root == null) {
            return 0;
        } else {
            // Menghitung tinggi dari masing-masing subtree
            int lheight = height(root.left);
            int rheight = height(root.right);

            if(lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    void PrintCurrentLevel(Node root, int level) {
        if(root == null) {
            return;
        } else if (level == 1){
            System.out.print(root.key + " ");
        } else if (level > 1) {
            PrintCurrentLevel(root.left, level - 1);
            PrintCurrentLevel(root.right, level - 1);
        }
    }

    /* Menghitung Ketinggian Tree */
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

    public static void main(String[] args) {
        Praktikum11_BinaryTree tree = new Praktikum11_BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);

        System.out.println("In Order traversal of binary tree is: ");
        tree.PrintInOrder();

//        System.out.println("Pre Order traversal of binary tree is: ");
//        tree.PrintPreorder();

//        System.out.println("Post Order traversal of binary tree is: ");
//        tree.PrintPostorder();
//        System.out.println("Level order traversal of binary tree is:");
//        tree.PrintLevelOrder();

//        System.out.println("Height of binary tree: " + tree.MaxDepth(tree.root));
        tree.delete(tree.root, 3);
        System.out.println("\nInorder Traversal after deletion:");
        tree.PrintInOrder();
    }
}
