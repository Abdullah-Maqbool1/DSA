// Node class - Binary Search Tree ka ek node represent karta hai
class Node {
    int data;           // Data store karta hai
    Node left, right;   // Left aur right child nodes

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// BST class - Binary Search Tree ke operations implement karta hai
class BST {
    public Node root; // Root node of the BST

    // Node insert karne ka method
    public Node insert(Node root, int value) {
        if (root == null) {
            // Agar root null hai, to new node banake return karo
            return new Node(value);
        }
        if (value < root.data)
            // Agar value choti hai to left subtree mein insert karo
            root.left = insert(root.left, value);
        else if (value > root.data)
            // Agar value badi hai to right subtree mein insert karo
            root.right = insert(root.right, value);

        return root; // Return the updated root node
        // Time Complexity:
        // Best Case:     O(log n)   -> Tree is balanced
        // Average Case:  O(log n)
        // Worst Case:    O(n)       -> Tree is skewed (like a linked list)

    }

    // Kisi value ko BST mein search karne ka method
    public boolean search(Node root, int key) { //
        if (root == null) return false;       // Node not found
        if (key == root.data) return true;    // Node found
        if (key < root.data)
            return search(root.left, key);    // Left mein search karo
        else
            return search(root.right, key);   // Right mein search karo

        // Time Complexity:
        // Best Case:     O(1)       -> Root matches the key
        // Average Case:  O(log n)
        // Worst Case:    O(n)       -> Skewed tree (all nodes in one side)
    }

    Node deleteNode(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: get inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    // Pre-order traversal: Root -> Left -> Right
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // In-order traversal: Left -> Root -> Right (Sorted order milta hai)
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Post-order traversal: Left -> Right -> Root
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

// Main class jahan program start hota hai
public class BST_Using_LinkedList {
    public static void main(String[] args) {
        BST bst = new BST();  // BST object banaya

        // Values insert kar rahe hain BST mein
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.root = bst.insert(bst.root, val);
        }

        // In-order traversal (sorted order)
        System.out.print("In-order: ");
        bst.inOrder(bst.root);
        System.out.println();

        // Pre-order traversal
        System.out.print("Pre-order: ");
        bst.preOrder(bst.root);
        System.out.println();

        // Post-order traversal
        System.out.print("Post-order: ");
        bst.postOrder(bst.root);
        System.out.println();

        // Searching values
        System.out.println("Search 40: " + bst.search(bst.root, 40));     // true
        System.out.println("Search 100: " + bst.search(bst.root, 100));   // false

        // Deleting node 50
        bst.root = bst.deleteNode(bst.root, 50);
        System.out.print("In-order after deleting 50: ");
        bst.inOrder(bst.root);
        System.out.println();
    }
}
