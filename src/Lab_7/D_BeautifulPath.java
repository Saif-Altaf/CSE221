package Lab_7;

import java.io.*;
import java.util.*;

public class D_BeautifulPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int s = Integer.parseInt(line1[2]);
        int d = Integer.parseInt(line1[3]);

        int[] weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(line2[i - 1]);
        }

        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line3 = br.readLine().split(" ");
            adjlist.get(Integer.parseInt(line3[0]))
                    .add(Integer.parseInt(line3[1]));
        }
        if (s == d) {
            System.out.println(weight[s]);
            return;
        }
        dijkstra(adjlist, n, s, d, weight);
    }

    public static void dijkstra(ArrayList<ArrayList<Integer>> adjlist, int n, int s, int d, int[] weight) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = weight[s];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(weight[s], s));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;
            int cost = current.distance;

            if (cost > dist[u])
                continue;

            for (int v : adjlist.get(u)) {
                int newCost = cost + weight[v];
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.offer(new Pair(newCost, v));
                }
            }
        }

        if (dist[d] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[d]);
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
}
