public class BinaryTreeDepth {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
    }

    // Write a method that returns the maximum depth of a binary tree. The maximum depth is the number of nodes from
    // the root (inclusive) until the furthest node (inclusive).
    static int depthBinaryTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depthBinaryTree(node.left), depthBinaryTree(node.right));
    }
}
