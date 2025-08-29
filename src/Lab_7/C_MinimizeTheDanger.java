package Lab_7;

import java.io.*;
import java.util.*;

public class C_MinimizeTheDanger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        ArrayList<ArrayList<Edge>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            adjlist.get(u).add(new Edge(v, w));
            adjlist.get(v).add(new Edge(u, w));
        }
        int[] dis = djikstra(adjlist, n, 1);
        for (int i = 1; i <=n ; i++) {
            if(i==n){
                System.out.print(dis[i]);
                return;
            }
            System.out.print(dis[i]+" ");
        }
    }

    public static int[] djikstra(ArrayList<ArrayList<Edge>> adjlist, int n, int s) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // Changed from -1 to MAX_VALUE
        dist[s] = 0;

        // Use PriorityQueue to get minimum danger path
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(0, s));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            int d_u = current.distance;

            // Skip if we found a better path
            if (d_u > dist[u]) {
                continue;
            }

            for (Edge edge : adjlist.get(u)) {
                int v = edge.destination;
                int danger = edge.weight;

                // Calculate maximum danger in the path
                int newDanger = Math.max(dist[u], danger);

                // Update if we found a path with less maximum danger
                if (newDanger < dist[v]) {
                    dist[v] = newDanger;
                    pq.offer(new Pair(newDanger, v));
                }
            }
        }

        // Convert MAX_VALUE to -1 for unreachable cities
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
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
