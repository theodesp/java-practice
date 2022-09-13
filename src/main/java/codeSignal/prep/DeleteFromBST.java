package codeSignal.prep;

/**
 * You're given a binary search tree t and an array of numbers queries. Your task is to remove queries[0], queries[1], etc., from t, step by step, following the algorithm above. 
 * Return the resulting BST.
 */
public class DeleteFromBST {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        var queries = new int[]{4, 5, 6};
        var t = new Tree<Integer>(5);
        t.left = new Tree<Integer>(2);
        t.left.left = new Tree<Integer>(1);
        t.left.right = new Tree<Integer>(3);
        t.right = new Tree<Integer>(6);
        t.right.right = new Tree<Integer>(8);
        t.right.right.left = new Tree<Integer>(7);
        var res = solution(t, queries);
        System.out.println();
    }

    static Tree<Integer> solution(Tree<Integer> t, int[] queries) {
        for (var query: queries) {
            delete(t, query);
        }
        return t;
    }

    static Tree<Integer> delete(Tree<Integer> t, int d) {
        if (t == null) {
            return t;
        }
        if (t.value == d) {
            // node with only one child or no child
            if (t.left == null)
                return t.right;
            else if (t.right == null)
                return t.left;


            t.value = minValue(t.right);
            t.right = delete(t.right, t.value);
        }else {
            if (d < t.value) {
                t.left = delete(t.left, d);
            } else if (d > t.value) {
                t.right = delete(t.right, d);
            }
            
        }
        
        return t;
    }

    static int minValue(Tree<Integer> t)
    {
        int min = t.value;
        while (t.left != null) 
        {
            min = t.left.value;
            t = t.left;
        }
        return min;
    }

    static Tree<Integer> find(Tree<Integer> t, int d) {
        if (t == null || t.value == d) {
            return t;
        }
        if (t.left != null && t.left.value > d) {
            return find(t.left, d);
        }
        if (t.right != null && t.right.value < d) {
            return find(t.left, d);
        }

        return null;
    }
}
