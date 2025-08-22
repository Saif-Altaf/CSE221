package Lab_6;

import java.io.*;
import java.util.*;

public class F_NearestTourDestination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int S = Integer.parseInt(line[2]);
        int Q = Integer.parseInt(line[3]);

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] line2 = br.readLine().split(" ");
            int u = Integer.parseInt(line2[0]);
            int v = Integer.parseInt(line2[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        String[] line3 = br.readLine().split(" ");
        int[] sources = new int[S];
        for (int i = 0; i < S; i++) {
            sources[i] = Integer.parseInt(line3[i]);
        }

        String[] line4 = br.readLine().split(" ");
        int[] dests = new int[Q];
        for (int i = 0; i < Q; i++) {
            dests[i] = Integer.parseInt(line4[i]);
        }

        // Multi-source BFS
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int src : sources) {
            dist[src] = 0;
            q.add(src);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neigh : adjList.get(curr)) {
                if (dist[neigh] == -1) {
                    dist[neigh] = dist[curr] + 1;
                    q.add(neigh);
                }
            }
        }

        // Answer queries
        StringBuilder sb = new StringBuilder();
        for (int d : dests) {
            sb.append(dist[d]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
