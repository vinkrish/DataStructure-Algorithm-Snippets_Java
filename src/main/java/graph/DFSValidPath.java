package graph;

import java.util.*;

/*
 * /explore/learn/card/graph/619/depth-first-search-in-graph/3893/
 * 
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * eg: 
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * 
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 */
public class DFSValidPath {

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
	
	public static boolean isValidPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacency_list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjacency_list.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);
        
        while(!stack.isEmpty()) {
            int node = stack.pop();
            
            if(node == destination) {
                return true;
            }
            
            if(seen[node]) {
                continue;
            }
            seen[node] = true;
            
            for(int neighbor: adjacency_list.get(node)) {
                stack.push(neighbor);
            }
        }
        
        return false;
    }

}
