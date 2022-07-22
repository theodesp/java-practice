public class BinaryTreeLevel {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int key;
    }
    // Given a Binary Tree and a key, write a function that returns level of the key.
    public static int findBinaryTreeLevel(int key, TreeNode root) {
        return findBinaryTreeLevelUntil(key, root, 1);
    }
    // Time Complexity of getLevel() is O(n) where n is the number of nodes in the given Binary Tree.
    public static int findBinaryTreeLevelUntil(int key, TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        if (key == root.key) {
            return level;
        }
        if (key > root.key) {
            level = findBinaryTreeLevelUntil(key, root.right, level + 1);
        } else {
            level = findBinaryTreeLevelUntil(key, root.left, level + 1);
        }
        return level;
    }
}
