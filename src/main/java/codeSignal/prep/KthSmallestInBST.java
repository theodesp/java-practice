package codeSignal.prep;

import java.util.*;

/**
 * Given a binary search tree t, find the kth smallest element in it.
 * Note that kth smallest element means kth element in increasing order. See examples for better understanding.
 * 
 *  3
 /   \
1     5
     / \
    4   6

and k = 4, the output should be
solution(t, k) = 5.
 */
public class KthSmallestInBST {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        var t = new Tree<Integer>(3);
        t.left = new Tree<Integer>(1);
        t.right = new Tree<Integer>(5);
        t.right.left = new Tree<Integer>(4);
        t.right.right = new Tree<Integer>(6);
        System.out.println(solution(t, 4));
    }

    static int solution(Tree<Integer> t, int k) {
        var list =  new ArrayList<Integer>();
        buildList(t, list);
        return list.get(k-1);
    }

    static void buildList(Tree<Integer> t, List<Integer> l) {
        if (t == null) {
            return;
        }
        buildList(t.left, l);
        l.add(t.value);
        buildList(t.right, l);
    }
}

// serialize to array
// find kth element from start