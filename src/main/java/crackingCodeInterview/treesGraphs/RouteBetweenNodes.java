package crackingCodeInterview.treesGraphs;

import java.util.*;

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(5, 6);

        System.out.println(hasRoute(g, 0, 5));
        System.out.println(hasRoute(g, 1, 3));
    }

    static boolean hasRoute(Graph g, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        var visited = new boolean[g.size()];
        queue.add(start);
        visited[start] = true;
        while (queue.size() > 0) {
            var s = queue.poll();
            for (var n : g.adj(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return visited[end];
    }
}
