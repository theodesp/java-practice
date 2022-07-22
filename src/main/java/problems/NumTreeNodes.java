public class NumTreeNodes {
    class TreeNode {
        public TreeNode left;
        public TreeNode right;
    }
    /*
     * Write a method that returns the number of nodes in a binary tree.
     */
    int getNumberOfNodes(TreeNode node) {
       if (node == null) {
           return 0;
       }
       return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
    }
}
