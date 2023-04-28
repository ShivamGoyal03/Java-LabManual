// Kruskal's Algorithm
// Shivam
// 21CSU090

import java.util.Scanner;
import java.util.Arrays;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w){
    	this.src = s;
    	this.dest = d;
    	this.weight = w;
    }

    public int compareTo(Edge compareEdge) {
	    return this.weight - compareEdge.weight;
    }
}

public class Practical6b {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices: ");
		int vertices = sc.nextInt();
		System.out.print("Enter the number of edges: ");
		int edges = sc.nextInt();

		System.out.println("\nEnter the source, destination and weight of edges:");
		Edge[] edge = new Edge[edges];
		for (int i = 0; i < edges; i++){
			// System.out.print("\nEnter the src, dest, weight of "+(i+1)+" edge: ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wei = sc.nextInt();
		    edge[i] = new Edge(src,dest,wei);
		}
		
		int tcost = 0;
		Edge[] mst = kruskal(vertices,edge);

	    System.out.println("\nMinimum Spanning Tree");
		for (Edge tedge : mst) {
		    System.out.println(tedge.src + " - " + tedge.dest + ": " + tedge.weight);
			tcost+=tedge.weight;
		}
	    System.out.println("\nTotal Cost:"+tcost);
	}

	static int findParent(int[] parent, int u) {
        if (parent[u] != u) {
            parent[u] = findParent(parent, parent[u]);
        }
        return parent[u];
    }

	static Edge[] kruskal(int vertices, Edge[] edges){
		Arrays.sort(edges);
		Edge[] mst = new Edge[vertices-1];

		int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int mstIndex = 0;
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            int parentU = findParent(parent, u);
            int parentV = findParent(parent, v);

            if (parentU != parentV) {
                mst[mstIndex] = edge;
                mstIndex++;

                parent[parentU] = parentV;

                if (mstIndex == vertices - 1) {
                    break;
                }
            }
        }
        return mst;
	}
}

/*
-------------------------------------------Test Cases---------------------------------------------
Test Case 1
5
10
0 1 2
0 3 6
0 4 3
1 2 3
1 3 8
1 4 5
2 4 7
3 4 9
2 1 4
4 2 5

Output:
0 - 1: 2
0 - 4: 3
1 - 2: 3
0 - 3: 6
Total Cost:14


Test Case 2
Input
9
14
0 1 4
0 7 8
1 7 11
1 2 8
7 6 1
7 8 7
2 8 2
2 3 7
2 5 4
8 6 6
6 5 2
3 4 9
3 5 14
5 4 10

Output:
7 - 6: 1
2 - 8: 2
6 - 5: 2
0 - 1: 4
2 - 5: 4
2 - 3: 7
0 - 7: 8
3 - 4: 9
Total Cost:37
*/