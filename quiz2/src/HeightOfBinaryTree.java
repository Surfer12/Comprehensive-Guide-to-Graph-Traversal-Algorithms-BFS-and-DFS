// Write a Java method to calculate the height of a binary tree.

import java.util.Comparator;

public class HeightOfBinaryTree {
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

    public int heightOfBinaryTreeMethod(Node root) implements Comparator<Node> {
        if (root == null) {
            return 0;
        }
        // Find the height of the left and right subtrees in the given binary tree
        // Determine which one is greater and return the greater value. 
        int leftHeight = heightOfBinaryTreeMethod(root.left); 
        int rightHeight = heightOfBinaryTreeMethod(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
        
    }
}
