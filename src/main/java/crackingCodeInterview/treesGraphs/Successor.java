package crackingCodeInterview.treesGraphs;
import java.util.*;
/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. 
 * You may assume that each node has a link to its parent.
 * In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree. Inorder Successor is NULL for the last node in Inorder traversal. 
 */
public class Successor {
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
        var res = successor(t, 3);
        System.out.println(res.value);
    }

    static Tree<Integer> successor(Tree<Integer> t, Integer key) {
        var stack = new Stack<Tree<Integer>>();
        var curr = t;
        while(curr != null || !stack.isEmpty()){
            // navigate to the leftmost node
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr.value > key)
                return curr;
            curr = curr.right;
        }
        return null;
    }
}
