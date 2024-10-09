package graph.usual;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * In an edge list representation, the graph is stored as a list of edges. 
 * Each edge is represented as a pair (u, v) for unweighted graphs, or a triplet (u, v, weight) for weighted graphs. 
 * This representation is useful for algorithms that work directly on edges, like Kruskal’s algorithm for finding Minimum Spanning Tree (MST).
 */
public class EdgeListGraph {
    private List<int[]> edgeList;
    private int numVertices;

    public EdgeListGraph(int numVertices) {
        this.numVertices = numVertices;
        edgeList = new ArrayList<>();
    }

    public void addEdge(int i, int j) {
        edgeList.add(new int[]{i, j});
    }
    
    // Convert the edge list to adjacency list for BFS and DFS
    private List<Integer>[] convertToAdjacencyList() {
        List<Integer>[] adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);  // For undirected graph
            adjList[v].add(u);
        }
        return adjList;
    }
    
    // DFS Traversal starting from a given vertex
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        List<Integer>[] adjList = convertToAdjacencyList();  // Convert edge list to adjacency list
        dfsRecursive(startVertex, visited, adjList);
    }

    // Recursive DFS function
    private void dfsRecursive(int vertex, boolean[] visited, List<Integer>[] adjList) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited, adjList);
            }
        }
    }

    // BFS Traversal starting from a given vertex
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        List<Integer>[] adjList = convertToAdjacencyList();  // Convert edge list to adjacency list

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	EdgeListGraph graph = new EdgeListGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        
        System.out.println("DFS Traversal starting from vertex 0:");
        graph.dfs(0);  // Expected output: 0 1 2 3
        
        System.out.println();
        
        System.out.println("BFS Traversal starting from vertex 0:");
        graph.bfs(0);  // Expected output: 0 1 2 3
        
        System.out.println();

        System.out.println("Traversing the Edge List:");
        graph.traverseEdgeList();
    }

    public void traverseEdgeList() {
        for (int[] edge : edgeList) {
        	System.out.println("Edge: " + edge[0] + " - " + edge[1]);
        }
    }
}

/*
Space Complexity: O(E) where E is the number of edges.

Time Complexity:
	Checking if an edge exists: O(E).
	Adding an edge: O(1) if you append to the list.
	Traversing neighbors: O(E) as you would need to scan all edges.
*/
