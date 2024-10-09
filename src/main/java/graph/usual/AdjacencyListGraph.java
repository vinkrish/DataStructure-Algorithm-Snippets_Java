package graph.usual;

import java.util.LinkedList;
import java.util.Queue;

/*
 * An adjacency list is an array (or list) of lists. Each index represents a vertex, and the list at that index contains the vertices that are adjacent to it. 
 * For a weighted graph, the adjacent vertices can be stored along with the weight of the edge.
 */

public class AdjacencyListGraph {
    private LinkedList<Integer>[] adjList;
    private int numVertices;

    public AdjacencyListGraph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        adjList[i].add(j);
        adjList[j].add(i);  // For undirected graph
    }

    public void removeEdge(int i, int j) {
        adjList[i].remove(Integer.valueOf(j));
        adjList[j].remove(Integer.valueOf(i));  // For undirected graph
    }
    
    // DFS starting from a given vertex
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];  // Keep track of visited vertices
        dfsRecursive(startVertex, visited);
    }

    // Recursive DFS function
    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;  // Mark current node as visited
        System.out.print(vertex + " ");  // Print the vertex

        // Recur for all vertices adjacent to this vertex
        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
    
    // BFS starting from a given vertex
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];  // Keep track of visited vertices
        Queue<Integer> queue = new LinkedList<>();  // BFS uses a queue

        visited[startVertex] = true;  // Mark the starting node as visited
        queue.add(startVertex);  // Enqueue the start vertex

        while (!queue.isEmpty()) {
            int vertex = queue.poll();  // Dequeue a vertex
            System.out.print(vertex + " ");  // Print the dequeued vertex

            // Get all adjacent vertices of the dequeued vertex
            for (int neighbor : adjList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;  // Mark neighbor as visited
                    queue.add(neighbor);  // Enqueue the neighbor
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	AdjacencyListGraph graph = new AdjacencyListGraph(5);  // Create a graph with 5 vertices
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

        System.out.println();
        
        System.out.println("Adjacency List Representation of the Graph:");
        graph.traverseGraph();
    }

    public void traverseGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int vertex : adjList[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}

/*
Space Complexity: O(V + E) where V is the number of vertices and E is the number of edges.

Time Complexity:
	Checking if an edge exists between two vertices: O(V) in the worst case.
	Adding an edge: O(1) (assuming list append is O(1)).
	Finding all neighbors of a vertex: O(k) where k is the number of neighbors of the vertex.
*/