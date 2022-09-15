package crackingCodeInterview.treesGraphs;

/**
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of t h i s q u e s t i o n , 
 */
public class CheckBalanced {
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
        var res = isBalanced(t);
        System.out.println(res);
    }

    static boolean isBalanced(Tree<Integer> t) {
        if (t == null) {
            return true;
        }
        return Math.abs(height(t.left) - height(t.right)) < 2;

    }
    static int height(Tree<Integer> t) {
        if (t == null) {
            return 0;
        }
        int left = height(t.left);
        int right = height(t.right);
        return 1 + Math.max(left, right);
    }
}
