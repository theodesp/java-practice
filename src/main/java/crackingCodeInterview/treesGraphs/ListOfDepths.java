package crackingCodeInterview.treesGraphs;
import java.util.*;
/**
 *  Given a binary tree, design an algorithm which creates a linked list of all the nodes 
 * at each depth (e.g., if you have a tree with depth D, you'lI have D linked lists).
 */
public class ListOfDepths {
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
        var res = createLists(t);
        System.out.println(res);
    }

    static Integer[][] createLists(Tree<Integer> t) {
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<Tree<Integer>>();
        var depth = 0;
        result.add(new ArrayList<Integer>());
        result.get(depth).add(t.value);
        queue.add(t);
        while (!queue.isEmpty()) {
            result.add(new ArrayList<Integer>());
            depth++;
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                result.get(depth).add(tempNode.value);
            }
            
        }
        var temp =result.stream().map(arr -> arr.toArray(Integer[]::new)).toArray(Integer[][]::new);
        return temp;
        
    }
}
