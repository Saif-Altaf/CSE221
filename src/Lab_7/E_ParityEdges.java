package Lab_7;

import java.io.*;
import java.util.*;

public class E_ParityEdges {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        int node, dist, parity; // parity: 0 = even, 1 = odd

        State(int node, int dist, int parity) {
            this.node = node;
            this.dist = dist;
            this.parity = parity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[] u = new int[m];
        int[] v = new int[m];
        int[] w = new int[m];
        String[] uStr = br.readLine().split(" ");
        String[] vStr = br.readLine().split(" ");
        String[] wStr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            u[i] = Integer.parseInt(uStr[i]);
            v[i] = Integer.parseInt(vStr[i]);
            w[i] = Integer.parseInt(wStr[i]);
        }
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            adj.get(u[i]).add(new Edge(v[i], w[i]));
        }
        // dist[node][parity]: shortest distance to node with last edge of given parity
        int[][] dist = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        // Start from node 1, no previous edge, so try both parities
        dist[1][0] = 0;
        dist[1][1] = 0;
        pq.offer(new State(1, 0, 0));
        pq.offer(new State(1, 0, 1));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist > dist[cur.node][cur.parity]) {
                continue;
            }
            for (Edge e : adj.get(cur.node)) {
                int nextParity = e.weight % 2;
                if (nextParity == cur.parity) {
                    continue; // skip same parity
                }
                int newDist = cur.dist + e.weight;
                if (newDist < dist[e.to][nextParity]) {
                    dist[e.to][nextParity] = newDist;
                    pq.offer(new State(e.to, newDist, nextParity));
                }
            }
        }
        int ans = Math.min(dist[n][0], dist[n][1]);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
