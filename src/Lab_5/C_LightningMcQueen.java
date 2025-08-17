package Lab_5;

import java.io.*;
import java.util.*;

public class C_LightningMcQueen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        int S = Integer.parseInt(line1[2]);
        int D = Integer.parseInt(line1[3]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        if (M > 0) {
            String[] u = br.readLine().split(" ");
            String[] v = br.readLine().split(" ");

            for (int i = 0; i < M; i++) {
                int a = Integer.parseInt(u[i]);
                int b = Integer.parseInt(v[i]);

                adj.get(a).add(b);
                adj.get(b).add(a);
            }
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        int[] dist = new int[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);

        bfs(S, adj, dist, parent);

        if (dist[D] == -1) {
            System.out.println(-1);
            return;
        }

        System.out.println(dist[D]);
        List<Integer> path = new ArrayList<>();
        for (int cur = D; cur != -1; cur = parent[cur]) {
            path.add(cur);
        }
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" ");
        }
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