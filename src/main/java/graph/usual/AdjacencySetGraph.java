package graph.usual;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * An adjacency set is similar to an adjacency list, but instead of using a list to store neighbors, a set is used. 
 * This prevents duplicate edges and makes checking if a particular edge exists more efficient than an adjacency list.
 */
public class AdjacencySetGraph {
    private Set<Integer>[] adjSet;
    private int numVertices;

    public AdjacencySetGraph(int numVertices) {
        this.numVertices = numVertices;
        adjSet = new HashSet[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjSet[i] = new HashSet<>();
        }
    }

    public void addEdge(int i, int j) {
        adjSet[i].add(j);
        adjSet[j].add(i);  // For undirected graph
    }
    
    // DFS starting from a given vertex
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];  // Track visited vertices
        dfsRecursive(startVertex, visited);
    }

    // Recursive DFS function
    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;  // Mark the vertex as visited
        System.out.print(vertex + " ");  // Process the vertex (in this case, print it)

        // Recur for all neighbors (connected vertices) of the current vertex
        for (int neighbor : adjSet[vertex]) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
    
    // BFS starting from a given vertex
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];  // Track visited vertices
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;  // Mark the start vertex as visited
        queue.add(startVertex);  // Enqueue the start vertex

        while (!queue.isEmpty()) {
            int vertex = queue.poll();  // Dequeue a vertex
            System.out.print(vertex + " ");  // Process the vertex (in this case, print it)

            // Get all unvisited neighbors of the dequeued vertex
            for (int neighbor : adjSet[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;  // Mark the neighbor as visited
                    queue.add(neighbor);  // Enqueue the neighbor
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	AdjacencySetGraph graph = new AdjacencySetGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("DFS Traversal starting from vertex 0:");
        graph.dfs(0);  // Expected output: 0 1 2 3 4
        
        System.out.println();
        
        System.out.println("BFS Traversal starting from vertex 0:");
        graph.bfs(0);  // Expected output: 0 1 4 2 3
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int vertex : adjSet[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
    
}

/*
Space Complexity: O(V + E), where V is the number of vertices and E is the number of edges.

Time Complexity:
	Checking if an edge exists between two vertices: O(1) if using a HashSet.
	Adding an edge: O(1) if using a HashSet.
*/