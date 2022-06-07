package graph;

import java.util.*;

/*
 * /explore/learn/card/graph/619/depth-first-search-in-graph/3849/
 * Directed Acyclic Graph (DAG)
 * 
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class DFSAllPath {

	public static void main(String[] args) {
		int[][] edges = new int[4][];
		edges[0] = new int[] {1, 2};
		edges[1] = new int[] {3};
		edges[2] = new int[] {3};
		edges[3] = new int[] {};
		
		List<List<Integer>> paths = allPathsSourceTarget(edges);
		for(List<Integer> path: paths) {
			System.out.println("");
			System.out.println("New Path");
			for(int p: path) {
				System.out.print(p);
			}
		}
	}
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    public static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode: nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }

}
