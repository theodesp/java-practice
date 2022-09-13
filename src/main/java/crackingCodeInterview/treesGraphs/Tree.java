package crackingCodeInterview.treesGraphs;

import java.util.function.Consumer;

public class Tree {
    public TreeNode root;

    void inOrderTraversal(TreeNode node, Consumer<TreeNode> visit) {
        if (node != null) {
            inOrderTraversal(node.left, visit);
            visit.accept(node);
            inOrderTraversal(node.right, visit);
        }
    }

    void preOrderTraversal(TreeNode node, Consumer<TreeNode> visit) {
        if (node != null) {
            visit.accept(node);
            preOrderTraversal(node.left, visit);
            preOrderTraversal(node.right, visit);
        }
    }

    void postOrderTraversal(TreeNode node, Consumer<TreeNode> visit) {
        if (node != null) {
            postOrderTraversal(node.left, visit);
            postOrderTraversal(node.right, visit);
            visit.accept(node);
        }
    }
}
