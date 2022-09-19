package codeSignal.prep;

/**
 * Given two binary trees t1 and t2, determine whether the second tree is a subtree 
 * of the first tree. A subtree for vertex v in a binary tree t is a tree consisting 
 * of v and all its descendants in t. Determine whether or not there is a vertex
 *  v (possibly none) in tree t1 such that a subtree for vertex v (possibly empty) in t1 equals t2.

      t1:             t2:
       5              10
      / \            /  \
    10   7          4    6
   /  \            / \    \
  4    6          1   2   -1
 / \    \
1   2   -1

solution(t1, t2) = true
 */
public class IsSubtree {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        var first = new Tree<Integer>(5);
        first.left = new Tree<Integer>(10);
        first.right = new Tree<Integer>(7);
        first.left.left = new Tree<Integer>(4);
        first.left.right = new Tree<Integer>(6);
        first.left.right.right = new Tree<Integer>(-1);
        first.left.left.left = new Tree<Integer>(1);
        first.left.left.right = new Tree<Integer>(2);

        var second = new Tree<Integer>(10);
        second.left = new Tree<Integer>(4);
        second.right = new Tree<Integer>(6);
        second.right.right = new Tree<Integer>(-1);
        second.left.left = new Tree<Integer>(1);
        second.left.right = new Tree<Integer>(2);
        System.out.println(isSubtree(first, second));
    }

    static boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        return lookAtTree(t1, t2);
    }
    
    static boolean lookAtTree(Tree<Integer> t1, Tree<Integer> t2){
        // Base case
        if(t2 == null){
            return true;
        }
        // Base case
        if(t1 == null){
            return false;
        }
        // Check if both are equal
        if(checkTree(t1, t2)){
            return true;
        }
         // Check if left/right is subtree of another
        boolean check = (lookAtTree(t1.left, t2) || lookAtTree(t1.right, t2));
        return check;
    }
    
    static boolean checkTree(Tree<Integer> t1, Tree<Integer> t2){
        // base case
        if(t1 == null && t2 == null){
            return true;
        }
        // check if they are different pointers
        if(t1 == null || t2 == null){
            return false;
        }
        // check their values and their subtrees
        boolean check = (t1.value.equals(t2.value) && checkTree(t1.left, t2.left) && checkTree(t1.right, t2.right));
        return check;
    }
}
