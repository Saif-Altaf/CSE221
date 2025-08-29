package Lab_7;

import java.io.*;
import java.util.*;

public class F_ShortestPathRevisited {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int s = Integer.parseInt(line1[2]);
        int d = Integer.parseInt(line1[3]);

        ArrayList<ArrayList<Edge>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line2 = br.readLine().split(" ");
            adjlist.get(Integer.parseInt(line2[0]))
                    .add(new Edge(Integer.parseInt(line2[1]), Integer.parseInt(line2[2])));
            adjlist.get(Integer.parseInt(line2[1]))
                    .add(new Edge(Integer.parseInt(line2[0]), Integer.parseInt(line2[2])));
        }
        djikstra(adjlist, n, s, d);
    }

    public static void djikstra(ArrayList<ArrayList<Edge>> adjlist, int n, int s, int d) {
        // Array to store shortest and second shortest distances
        int[] dist1 = new int[n + 1]; // For shortest path
        int[] dist2 = new int[n + 1]; // For second shortest path

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[s] = 0;

        // PriorityQueue stores (distance, vertex, isSecond)
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new State(0, s, false));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.vertex;
            int d_u = current.distance;
            boolean isSecond = current.isSecond;

            // Skip if we already found a better path
            if (isSecond && d_u > dist2[u])
                continue;
            if (!isSecond && d_u > dist1[u])
                continue;

            for (Edge edge : adjlist.get(u)) {
                int v = edge.destination;
                int newDist = d_u + edge.weight;

                // Update shortest path
                if (newDist < dist1[v]) {
                    dist2[v] = dist1[v];
                    dist1[v] = newDist;
                    pq.offer(new State(newDist, v, false));
                    pq.offer(new State(dist2[v], v, true));
                }
                // Update second shortest path
                else if (newDist < dist2[v] && newDist > dist1[v]) {
                    dist2[v] = newDist;
                    pq.offer(new State(newDist, v, true));
                }
            }
        }

        // Print second shortest path if it exists
        if (dist2[d] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist2[d]);
        }
    }

    static class State {
        int distance;
        int vertex;
        boolean isSecond;

        public State(int distance, int vertex, boolean isSecond) {
            this.distance = distance;
            this.vertex = vertex;
            this.isSecond = isSecond;
        }
    }

    static class Pair {
        int distance;
        int vertex;

        public Pair(int distance, int vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }
    }

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
