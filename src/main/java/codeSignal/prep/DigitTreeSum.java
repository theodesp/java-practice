package codeSignal.prep;

import java.util.*;

/**
 * We're going to store numbers in a tree. 
 * Each node in this tree will store a single digit (from 0 to 9), 
 * and each path from root to leaf encodes a non-negative integer.

Given a binary tree t, find the sum of all the numbers encoded in it.

the output should be
t = {
    "value": 1,
    "left": {
        "value": 0,
        "left": {
            "value": 3,
            "left": null,
            "right": null
        },
        "right": {
            "value": 1,
            "left": null,
            "right": null
        }
    },
    "right": {
        "value": 4,
        "left": null,
        "right": null
    }
}
solution(t) = 218.
 */
public class DigitTreeSum {
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
        var res = solution(t);
        System.out.println();
    }

    static int solution(Tree<Integer> t) {
        return dfs(t, 0);
    }

    static int dfs(Tree<Integer> t, int currSum) {
        var sum = 0;
        if (t == null) {
            return sum;
        }

        sum = currSum*10 + t.value;
        
        if (t.left == null && t.right == null) {
            return sum;
        }

        return dfs(t.left, sum) + dfs(t.right, sum);
        
    }
}
