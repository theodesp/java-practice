public class StrictBinary {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
    }
    /**
     * A binary tree is strict when all nodes have either two or zero child nodes.
    // Write a method that checks if a binary tree is strict.
     */
    Boolean isStrictTree(TreeNode node) {
        if (node == null) {
            return false;
        }
        // Check clause of string binary tree
        if (node.left == null && node.right == null) {
            return true;
        }
        // Continue checking recursively to see if the clause is true for the left and right subtrees
        if (node.left != null && node.right != null) {
            return isStrictTree(node.left) && isStrictTree(node.right);
        }
        return false;
    }
}
