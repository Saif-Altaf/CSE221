package Lab_4;

import java.io.*;
import java.util.*;

public class AdjacencyListRepresentation {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = read.readLine().split(" ");
        int nodes = Integer.parseInt(line1[0]);
        int edge = Integer.parseInt(line1[1]);
        String[] s = read.readLine().split(" ");
        String[] d = read.readLine().split(" ");
        String[] w = read.readLine().split(" ");
        int[] source = new int[edge];
        int[] destination = new int[edge];
        int[] weight = new int[edge];
        for (int i = 0; i < edge; i++) {
            source[i] = Integer.parseInt(s[i]);
            destination[i] = Integer.parseInt(d[i]);
            weight[i] = Integer.parseInt(w[i]);
        }

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            adjList.get(source[i]).add(new Edge(destination[i], weight[i]));
        }

        for (int i = 1; i <= nodes; i++) {
            System.out.print(i + ":");
            for (Edge edg : adjList.get(i)) {
                System.out.print(" (" + edg.destination + ", " + edg.weight + ")");
            }
            System.out.println();
        }
    }
}

class Edge {

    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}