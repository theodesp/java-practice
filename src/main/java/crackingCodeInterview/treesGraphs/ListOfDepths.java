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
        var tree = new Tree<Integer>(1);

        var res = createLists(tree);
        System.out.println();
    }

    static List<List<Integer>> createLists(Tree<Integer> t) {
        Queue<Tree<Integer>> queue = new LinkedList<>();
        var map = new HashMap<Integer, List<Integer>>();
        var visited = new HashSet<Tree<Integer>>();
        visited.add(t);
        queue.add(t);
        var d =0;
        map.put( d++, Arrays.asList(t.value));
        while(queue.size() > 0) {
            var s = queue.poll();
            visited.add(s);
            if (s.left != null) {
                var r = map.putIfAbsent(d, new LinkedList<Integer>());
                r.add(s.value);
            }
            if (s.right != null) {
                var r = map.putIfAbsent(d, new LinkedList<Integer>());
                r.add(s.value);
            }
            queue.add(t);
            d++;
        }
        return result;
    }

    static createListsDepth(Tree<Integer> t, Set<Tree<Integer>> visited, result) {
        
    }
}
