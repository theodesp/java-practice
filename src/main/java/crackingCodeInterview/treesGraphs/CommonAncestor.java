package crackingCodeInterview.treesGraphs;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in
 *  a binary tree. Avoid storing additional nodes in a data structure. 
 * NOTE: This is not necessarily a binary search tree.
 */
public class CommonAncestor {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        var t = new Tree<Integer>(1);
        t.left = new Tree<Integer>(2);
        t.right = new Tree<Integer>(3);
        t.left.left = new Tree<Integer>(4);
        t.left.right = new Tree<Integer>(5);
        t.right.left = new Tree<Integer>(6);
        t.right.right = new Tree<Integer>(8);
        var res = findLCA(t, 4, 5);
        System.out.println(res);
    }

    static Tree<Integer> findLCA(Tree<Integer> t, int d1, int d2) {
        if (t == null) {
            return null;
        }
        if (t.value == d1 || t.value == d2)
            return t;

        // Look for keys in left and right subtrees
        var left = findLCA(t.left, d1, d2);
        var right = findLCA(t.right, d1, d2);

        if (left!=null && right!=null)
            return t;

        // Otherwise check if left subtree or right subtree is LCA
        return (left != null) ? left : right;
    }
}
