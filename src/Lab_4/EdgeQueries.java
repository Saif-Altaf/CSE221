package Lab_4;

import java.io.*;

public class EdgeQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = r.readLine().split(" ");
        int nodes = Integer.parseInt(line1[0]);
        int edges = Integer.parseInt(line1[1]);
        String[] line2 = r.readLine().split(" ");
        String[] line3 = r.readLine().split(" ");

        // Arrays to count in-degree and out-degree for each node
        int[] inDegree = new int[nodes + 1];
        int[] outDegree = new int[nodes + 1];

        // Process all edges and count degrees directly
        for (int i = 0; i < edges; i++) {
            int from = Integer.parseInt(line2[i]);
            int to = Integer.parseInt(line3[i]);
            outDegree[from]++;  // from node has one more outgoing edge
            inDegree[to]++;     // to node has one more incoming edge
        }

        // Output the difference for each node
        for (int node = 1; node <= nodes; node++) {
            System.out.print((inDegree[node] - outDegree[node]) + " ");
        }
    }
}