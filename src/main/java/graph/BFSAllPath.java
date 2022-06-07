package graph;

import java.util.*;

/*
 * /explore/learn/card/graph/620/breadth-first-search-in-graph/3853/
 * Directed Acyclic Graph (DAG)
 * 
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class BFSAllPath {

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

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.add(path);

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int node = currentPath.get(currentPath.size() - 1);
            for (int nextNode: graph[node]) {
                List<Integer> tmpPath = new ArrayList<>(currentPath);
                tmpPath.add(nextNode);
                if (nextNode == graph.length - 1) {
                    paths.add(new ArrayList<>(tmpPath));
                } else {
                    queue.add(new ArrayList<>(tmpPath));
                } 
            }
        }
        return paths;
    }

}
