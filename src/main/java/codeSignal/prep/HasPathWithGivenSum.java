package codeSignal.prep;

public class HasPathWithGivenSum {
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    static boolean solution(Tree<Integer> t, int s) {
        var result = false;
        if (t == null) {
            return false;
        }
        var subSum = s - t.value;
        if (subSum == 0 && isLeaf(t)) {
            result = true;
        } else {
            if (t.left != null) {
                result = solution(t.left, subSum) || result;
            }
            if (t.right != null) {
                result = solution(t.right, subSum) || result;
            } 
        }

        return result;
    }
 
    static boolean isLeaf(Tree<Integer> t) {
        return t != null && t.left == null && t.right == null;
    }
}
