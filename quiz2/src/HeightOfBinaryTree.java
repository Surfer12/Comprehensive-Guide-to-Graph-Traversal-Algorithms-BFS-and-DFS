import java.util.Queue;
import java.util.LinkedList;

public class HeightOfBinaryTree {
    
    // Nested Node class
    public static class Node {
        int data;
        Node left, right;
        
        public Node(int item) {
            data = item;
            left = right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Calculates the height of the binary tree recursively.
     * 
     * @param root The root node of the binary tree
     * @return The height of the tree. If the tree is empty, returns 0.
     */
    public int calculateHeightRecursive(Node root) {
        if (root == null) {
            return 0;  // Base case: empty tree has height 0
        }
        // Recursively find height of left and right subtrees and take the maximum
        return Math.max(calculateHeightRecursive(root.left), calculateHeightRecursive(root.right)) + 1;
    }

    /**
     * Calculates the height of the binary tree iteratively using level order traversal.
     * 
     * @param root The root node of the binary tree
     * @return The height of the tree. If the tree is empty, returns 0.
     */
    public int calculateHeightIterative(Node root) {
        if (root == null) {
            return 0;  // If root is null, tree is empty, height is 0
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);  // End of current level marker
        int height = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null);  // Add level marker for next level
                }
                height++;
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return height;
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        
        // Example tree creation
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        // Calculate and print the height using recursive method
        int heightRecursive = tree.calculateHeight(root);
        System.out.println("Height of the binary tree (Recursive): " + heightRecursive);

        // Calculate and print the height using iterative method
        int heightIterative = tree.calculateHeightIterative(root);
        System.out.println("Height of the binary tree (Iterative): " + heightIterative);
    }
}