package codeSignal.prep;

import java.util.*;

/**
 * You have a binary tree t. Your task is to find the largest value in each row
 * of this tree.
 * In a tree, a row is a set of nodes that have equal depth.
 * For example, a row with depth 0 is a tree root, a row with depth 1 is
 * composed of the root's children,
 * etc.
 * 
 * Return an array in which the first element is the largest value in the row
 * with depth 0,
 * the second element is the largest value in the row with depth 1, the third
 * element is the
 * largest element in the row with depth 2, etc.
 */
public class LargestValuesInTreeRows {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        var t = new Tree<Integer>(-1);
        t.left = new Tree<Integer>(5);
        t.right = new Tree<Integer>(7);
        t.right.right = new Tree<Integer>(8);
        t.right.right.left = new Tree<Integer>(9);
        var res = solution(t);
        System.out.println();
    }

    static int[] solution(Tree<Integer> t) {
        if (t == null)
            return new int[0];
        var s = new LinkedList<Tree<Integer>>();
        s.add(t);
        var result = new ArrayList<Integer>();

        while (s.size() > 0) {
            var size = s.size();
            var max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                var node = s.pollLast();
                if (node.value > max) {
                    max = node.value;
                }
                if (node.left != null) {
                    s.push(node.left);
                }
                if (node.right != null) {
                    s.push(node.right);
                }
            }
            result.add(max);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

}
