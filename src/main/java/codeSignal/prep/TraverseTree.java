package codeSignal.prep;

import java.util.*;

/**
 * Given a binary tree of integers t, return its node values in the following format:

The first element should be the value of the tree root;
The next elements should be the values of the nodes at height 1 (i.e. the root children), 
ordered from the leftmost to the rightmost one;
The elements after that should be the values of the nodes at height 2 
(i.e. the children of the nodes at height 1) ordered in the same way;
Etc.

 */
public class TraverseTree {
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
        var t = new Tree<Integer>(1);
        t.left = new Tree<Integer>(2);
        t.left.right = new Tree<Integer>(3);
        t.right = new Tree<Integer>(4);
        t.right.left = new Tree<Integer>(5);
        var res = solution(t);
        System.out.println(Arrays.toString(res));
    }

    static int[] solution(Tree<Integer> t) {
        if (t ==null) {
            return new int[0];
        }
        var res = new ArrayList<Integer>();
        var queue = new LinkedList<Tree<Integer>>();
        queue.add(t);
        while(queue.size() > 0) {
            var curr = queue.poll();
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
            res.add(curr.value);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
