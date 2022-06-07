package graph;

import java.util.*;

/*
 * explore/learn/card/graph/620/breadth-first-search-in-graph/3894/
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 */
public class BFSValidPath {

	public static void main(String[] args) {
		int[][] edges = new int[3][];
		edges[0] = new int[] {0, 1};
		edges[1] = new int[] {1, 2};
		edges[2] = new int[] {2, 0};
		
		int[][] edges2 =  new int[5][];
		edges2[0] = new int[] {0, 1};
		edges2[1] = new int[] {0, 2};
		edges2[2] = new int[] {3, 5};
		edges2[3] = new int[] {5, 4};
		edges2[4] = new int[] {4, 3};
		
		boolean isValidPath = isValidPath(3, edges, 0, 2);
//		boolean isValidPath = isValidPath(6, edges2, 0, 5);
		System.out.println(isValidPath);

	}
	
	public static boolean isValidPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacency_list = new ArrayList<>();        
        for(int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);
        seen[start] = true;
        
        while(!queue.isEmpty()) {
            // Get the current node.
            int node = queue.poll();
            
            // Check if we have reached the target node.
            if(node == end) {
                return true;
            }
            
            // Add all neighbors to the stack.
            for(int neighbor : adjacency_list.get(node)) {
                // Check if neighbor has been added to the queue before.
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }

}
