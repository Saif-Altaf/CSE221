package Lab_7;

import java.io.*;
import java.util.*;

public class B_WhereToMeet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int s = Integer.parseInt(line1[2]);
        int t = Integer.parseInt(line1[3]);

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
        }
        int[] dis_s = djikstra(adjlist, n, s);
        int[] dis_t = djikstra(adjlist, n, t);
        int min_time = Integer.MAX_VALUE;
        int meeting_node = -1;
        int time = 0;
        for (int i = 0; i <= n; i++) {
            if (dis_s[i] != Integer.MAX_VALUE && dis_t[i] != Integer.MAX_VALUE) {
                time = Integer.max(dis_s[i], dis_t[i]);
                if (time < min_time || (time == min_time && i < meeting_node)) {
                    min_time = time;
                    meeting_node = i;
                }
            }
        }
        if (meeting_node == -1) {
            System.out.println(-1);
        } else {
            System.out.println(min_time + " " + meeting_node);
        }
    }

    public static int[] djikstra(ArrayList<ArrayList<Edge>> adjlist, int n, int s) {
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


