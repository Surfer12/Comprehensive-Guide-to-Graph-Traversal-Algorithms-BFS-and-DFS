// Write a Java method to calculate the height of a binary tree.
// You can use any traversal method to calculate the height of the binary tree.
import java.util.Comparator;

public class HeightOfBinaryTree {
    int height = 0;
 public class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

// DETERMINE THE HEIGHT OF THE BINARY TREE USING a traversal method.
    // Method to calculate the height of the binary tree using recursive traversal

    public int dfsTraversal(Node root) {
        if (root == null) {
            return 0;
        }   
        System.out.print(root.data + " ");
        dfsTraversal(root.left);
        dfsTraversal(root.right);
        root.data++;
        height = Math.max(height, root.data);

        return height;
    }

    public int calculateHeight(Node root) {
        // Base case: if the node is null, height is 0
        if (root == null) {
            return 0;
        }


        int leftHeight = dfsTraversal(root.left);
        int rightHeight = dfsTraversal(root.right);

        
        // Return the maximum height plus 1 (to account for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public class HeightComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.data, node2.data);
        }
    }

    public int heightOfBinaryTreeMethod(Node root) {
        if (root == null) {
            return 0;
        }

        // Find the height of the left and right subtrees in the given binary tree
        // Determine which one is greater and return the greater value.
        int leftHeight = dfsTraversal(root.left);
        int rightHeight = dfsTraversal(root.right);
        
        // Determine which one is greater and return the greater value. 
        return HeightComparator.compare(root, root.left) > HeightComparator.compare(root, root.right) ? leftHeight : rightHeight;
        
    }
}
}
