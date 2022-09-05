package codeSignal.prep;

public class IsTreeSymmetric {
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {

    }

    static boolean solution(Tree<Integer> t) {
        if (t == null) return false;
        return isTreeSymmetric(t.left, t.right);
    }
    static boolean isTreeSymmetric(Tree<Integer> left, Tree<Integer> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.value == right.value) {
            return isTreeSymmetric(left.left, right.right) && isTreeSymmetric(left.right, right.left);
        }
        return false;
    }
}
