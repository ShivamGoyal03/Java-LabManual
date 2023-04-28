// Prims Algorithm
// Shivam
// 21CSU090

import java.util.*;

public class Practical6a {

    // Helper function to find the vertex with minimum distance value
    private int findMinVertex(int[] distance, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    // Function to print the constructed MST stored in parent array
    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public void prim(int[][] graph) {
        int numVertices = graph.length;
        int[] parent = new int[numVertices]; // Array to store constructed MST
        int[] distance = new int[numVertices]; // Key values used to pick minimum weight edge in cut
        boolean[] visited = new boolean[numVertices]; // To represent set of vertices not yet included in MST

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        // Always include first vertex in MST. Make its distance 0 so that this vertex
        // is picked as first vertex
        distance[0] = 0;
        parent[0] = -1; // First node is always root of MST

        // Find MST of all vertices
        for (int i = 0; i < numVertices - 1; i++) {
            // MST
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;

            // Update distance values of adjacent vertices of the picked vertex.
            // Consider only those vertices which are not yet included in MST
            for (int j = 0; j < numVertices; j++) {
                if (graph[minVertex][j] != 0 && !visited[j] && graph[minVertex][j] < distance[j]) {
                    parent[j] = minVertex;
                    distance[j] = graph[minVertex][j];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }

    public static void main(String[] args) {
        // Example graph
        // 0, 1, 2, 3, 4, 5, 6, 7, 8
        int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, // 0
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, // 1
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, // 2
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, // 3
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, // 4
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, // 5
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, // 6
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, // 7
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; // 8

        Practical6a pa = new Practical6a();
        pa.prim(graph);
    }
}
