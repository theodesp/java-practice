public class CountLeafNodes {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
    }

    /*
     * Count the number of leaf nodes in a binary tree
     */
    static int countLeafNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }
    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String []args) {
        TreeNode t = new TreeNode();
        t.left = new TreeNode();
        t.right = new TreeNode();
        t.left.left  =new TreeNode();
        System.out.println(countLeafNodes(t));
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Exit!");
            }
        });
    }
}
