public class StrictBinary {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
    }
    // A binary tree is strict when all nodes have either two or zero child nodes.
    // Write a method that checks if a binary tree is strict.
    Boolean isStrictTree(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left != null && node.right != null) {
            return isStrictTree(node.left) && isStrictTree(node.right);
        }
        return false;
    }
}
