class RouterNode {
    int routerId;
    RouterNode left, right;

    public RouterNode(int routerId) {
        this.routerId = routerId;
        this.left = null;
        this.right = null;
    }
}

class NetworkTree {
    RouterNode root;

    // Method to Insert Routers
    public RouterNode insert(RouterNode root, int id) {
        if (root == null) {
            return new RouterNode(id);
        }
        if (id < root.routerId) {
            root.left = insert(root.left, id);
        } else {
            root.right = insert(root.right, id);
        }
        return root;
    }

    // Inorder traversal - simulate data analysis
    public void inorder(RouterNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print("Router " + root.routerId + " -> ");
            inorder(root.right);
        }
    }

    // Preorder traversal - simulate initialization
    public void preorder(RouterNode root) {
        if (root != null) {
            System.out.print("Initializing Router " + root.routerId + " -> ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder traversal - simulate shutdown
    public void postorder(RouterNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print("Shutting down Router " + root.routerId + " -> ");
        }
    }
}

// Main class to simulate
public class Scenario04 {
    public static void main(String[] args) {
        NetworkTree network = new NetworkTree();

        // Example router network
        int[] routerIds = {50, 30, 70, 20, 40, 60, 80};
        for (int id : routerIds) {
            network.root = network.insert(network.root, id);
        }

        System.out.println("=== Data Analysis (Inorder Traversal) ===");
        network.inorder(network.root);
        System.out.println("\n");

        System.out.println("=== Initialization Sequence (Preorder Traversal) ===");
        network.preorder(network.root);
        System.out.println("\n");

        System.out.println("=== Shutdown Sequence (Postorder Traversal) ===");
        network.postorder(network.root);
        System.out.println();
    }
}
