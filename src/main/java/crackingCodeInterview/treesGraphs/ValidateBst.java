package crackingCodeInterview.treesGraphs;

/**
 *  Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBst {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        var t = new Tree<Integer>(5);
        t.left = new Tree<Integer>(2);
        t.left.left = new Tree<Integer>(1);
        t.left.right = new Tree<Integer>(3);
        t.right = new Tree<Integer>(6);
        t.right.right = new Tree<Integer>(8);
        t.right.right.left = new Tree<Integer>(7);
        var res = isValid(t);
        System.out.println(res);
    }

    static boolean isValid(Tree<Integer> t) {
        if (t == null) {
            return true;
        }
        if (t.left != null && t.value < t.left.value) {
            return false;
        }
        if (t.right != null && t.value > t.right.value) {
            return false;
        }
        var isValidLeft = isValid(t.left);
        var isValidRight = isValid(t.right);

        return isValidLeft && isValidRight;
    }
}
