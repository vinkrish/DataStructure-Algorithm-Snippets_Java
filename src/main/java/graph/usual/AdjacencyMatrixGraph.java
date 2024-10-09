package graph.usual;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * An adjacency matrix is a 2D array (or matrix) where each cell [i][j] represents the edge between vertex i and vertex j. 
 * For unweighted graphs, the value at [i][j] is typically 1 if there is an edge from vertex i to vertex j, otherwise 0. 
 * In the case of weighted graphs, the cell will contain the weight of the edge instead of 1.
 */

public class AdjacencyMatrixGraph {
    private int[][] adjMatrix;
    private int numVertices;

    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;  // For undirected graph
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;  // For undirected graph
    }
    
 // Depth-First Search (DFS) using recursion
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        dfsRecursive(startVertex, visited);
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }
    
 // Breadth-First Search (BFS) using a queue
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	
    	/*
			    0
			   / \
			  1---2
			   \ /
			    3

    	AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        
    	*/
    	
        /*
		        0
		       / \
		      1   2
		     / \  / \
		    3   4 5  6
		*/
    	
    	AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(7);
    	
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("DFS Traversal starting from vertex 0:");
        graph.dfs(0);
        
        System.out.println();
        
        System.out.println("BFS Traversal starting from vertex 0:");
        graph.bfs(0);
        
        System.out.println();
        
        System.out.println("Traverse the entire adjacency matrix and print the edges(1 represent edge exist):");
        graph.traverseGraph();
    }

    public void traverseGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Space Complexity: O(V^2) where V is the number of vertices.

Time Complexity:
	Checking if an edge exists between two vertices: O(1)
	Adding/removing an edge: O(1)
	Finding all neighbors of a vertex: O(V)
*/