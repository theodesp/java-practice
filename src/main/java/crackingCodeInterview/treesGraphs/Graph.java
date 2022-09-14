package crackingCodeInterview.treesGraphs;

import java.util.function.Consumer;
import java.util.*;

public class Graph {
    private int V; // No. of vertices
    private List<List<Integer>> adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < v; ++i) {
            adj.add(new LinkedList<Integer>());
        }
    }

    int size() {
        return V;
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    List<Integer> adj(int v) {
        return adj.get(v);
    }

    void dfs(Consumer<Integer> visit) {
        var visited = new boolean[V];
        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited, visit);
    }

    void DFSUtil(int v, boolean[] visited, Consumer<Integer> visit) {
        // Mark the current node as visited and print it
        visited[v] = true;
        visit.accept(v);

        for (var n: adj.get(v)) {
            if (!visited[n])
                DFSUtil(n, visited, visit);
        }
    }

    void bfs(int root, Consumer<Integer> visit) {
        Queue<Integer> queue = new LinkedList<>();
        var visited = new boolean[V];
        visited[root]=true;
        visit.accept(root);
        queue.add(root);
        while(queue.size() > 0) {
            var s = queue.poll();
            visit.accept(s);

            for (var n: adj.get(s)) {
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(v -> System.out.println(v));
    }
}
