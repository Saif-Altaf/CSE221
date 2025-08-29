package Lab_7;

import java.io.*;
import java.util.*;

public class A_ShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        String[] line3 = br.readLine().split(" ");
        String[] line4 = br.readLine().split(" ");

        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int s = Integer.parseInt(line1[2]);
        int d = Integer.parseInt(line1[3]);

        ArrayList<ArrayList<Edge>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 0; i < line2.length; i++) {
            adjlist.get(Integer.parseInt(line2[i]))
                    .add(new Edge(Integer.parseInt(line3[i]), Integer.parseInt(line4[i])));
        }
        djikstra(adjlist, n, s, d);
    }

    public static void djikstra(ArrayList<ArrayList<Edge>> adjlist, int n, int s, int d) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        int[] prev = new int[n + 1];
        Arrays.fill(prev, -1);

        // PriorityQueue of pairs (distance, vertex)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(0, s));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            int d_u = current.distance;

            // Skip if we already found a better path
            if (d_u > dist[u]) {
                continue;
            }

            // Process all neighbors
            for (Edge edge : adjlist.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                // Relaxation
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }

        // If destination is unreachable
        if (dist[d] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        // Print shortest distance
        System.out.println(dist[d]);

        // Reconstruct and print path
        ArrayList<Integer> path = new ArrayList<>();
        for (int cur = d; cur != -1; cur = prev[cur]) {
            path.add(cur);
        }

        // Print path in reverse order (from source to destination)
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}

class Pair {
    int distance;
    int vertex;

    public Pair(int distance, int vertex) {
        this.distance = distance;
        this.vertex = vertex;
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
