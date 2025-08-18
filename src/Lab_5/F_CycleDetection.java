package Lab_5;

import java.io.*;
import java.util.*;

public class F_CycleDetection {
    static List<Integer>[] adj;
    static int[] state; // 0 = not visited, 1 = visiting, 2 = visited
    static boolean hasCycle = false;

    static void dfs(int u) {
        state[u] = 1; // mark as visiting
        for (int v : adj[u]) {
            if (state[v] == 0) {
                dfs(v);
                if (hasCycle) return;
            } else if (state[v] == 1) {
                hasCycle = true;
                return;
            }
        }
        state[u] = 2; // mark as fully visited
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        state = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (state[i] == 0) {
                dfs(i);
                if (hasCycle) break;
            }
        }

        System.out.println(hasCycle ? "YES" : "NO");
    }
}
