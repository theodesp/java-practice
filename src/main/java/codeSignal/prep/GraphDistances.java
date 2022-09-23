package codeSignal.prep;

import java.util.*;
/**
 * You have a strongly connected directed graph that has positive weights in the adjacency matrix g. 
 * The graph is represented as a square matrix, where g[i][j] is the weight of the edge (i, j), or -1 if there is no such edge.

Given g and the index of a start vertex s, find the minimal 
distances between the start vertex s and each of the vertices of the graph.

g = [[-1, 3, 2],
     [2, -1, 0],
     [-1, 0, -1]]

and s = 0, the output should be
solution(g, s) = [0, 2, 2].
 */
public class GraphDistances {
    public static void main(String[] args) {
        int[][] g = { { -1, 3, 2 }, 
				      { 2, -1, 0 }, 
				      { -1, 0, -1 } };
		int s = 0;
		solution(g, s);
    }

    static int[] solution(int[][] g, int s) {
        ArrayList<Integer> res = new ArrayList<>(g.length);

		int[] isVisited = new int[g.length];

		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = 0;
		}
		System.out.println("---------- BFS --------------");
		BFS(g, s, isVisited);
    }

    /**
	 * 
	 * @param g
	 * @param s
	 * 
	 */
	static void BFS(int[][] g, int s, int[] isVisited) {
		Queue<Integer> storePoint = new LinkedList<>();
		storePoint.add(s);

		while (!storePoint.isEmpty()) {
			int point = storePoint.poll();
			
			if(isVisited[point] == 0) {
				System.out.print(point + " ");
				isVisited[point] = 1;
			}
			for (int i = 0; i < g[point].length; i++) {
				if (g[point][i] >= 0 && isVisited[i] != 1) {
					storePoint.add(i);
				}
			}
		}

		System.out.println();
	}
}
