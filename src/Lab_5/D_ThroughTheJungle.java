package Lab_5;

import java.io.*;
import java.util.*;

public class D_ThroughTheJungle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        int S = Integer.parseInt(line1[2]);
        int D = Integer.parseInt(line1[3]);
        int K = Integer.parseInt(line1[4]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] u = br.readLine().split(" ");

            int a = Integer.parseInt(u[0]);
            int b = Integer.parseInt(u[1]);

            adj.get(a).add(b);
        }

        // Find shortest path from S to K
        int[] distSK = new int[N + 1];
        int[] parentSK = new int[N + 1];
        Arrays.fill(distSK, -1);
        Arrays.fill(parentSK, -1);
        bfs(S, adj, distSK, parentSK);

        // Find shortest path from K to D
        int[] distKD = new int[N + 1];
        int[] parentKD = new int[N + 1];
        Arrays.fill(distKD, -1);
        Arrays.fill(parentKD, -1);
        bfs(K, adj, distKD, parentKD);

        if (distSK[K] == -1 || distKD[D] == -1) {
            System.out.println(-1);
            return;
        }

        // Reconstruct S->K path
        List<Integer> pathSK = new ArrayList<>();
        for (int cur = K; cur != -1; cur = parentSK[cur]) {
            pathSK.add(cur);
        }
        Collections.reverse(pathSK);

        // Reconstruct K->D path
        List<Integer> pathKD = new ArrayList<>();
        for (int cur = D; cur != -1; cur = parentKD[cur]) {
            pathKD.add(cur);
        }
        Collections.reverse(pathKD);

        // Remove duplicate K from pathKD
        if (pathKD.size() > 0 && pathKD.get(0) == K) {
            pathKD.remove(0);
        }

        // Combine paths
        List<Integer> fullPath = new ArrayList<>(pathSK);
        fullPath.addAll(pathKD);

        System.out.println(fullPath.size() - 1);
        for (int i = 0; i < fullPath.size(); i++) {
            System.out.print(fullPath.get(i));
            if (i < fullPath.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static void bfs(int start, ArrayList<ArrayList<Integer>> adjlist, int[] dist, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nei : adjlist.get(curr)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[curr] + 1;
                    parent[nei] = curr;
                    q.add(nei);
                }
            }
        }
    }
}