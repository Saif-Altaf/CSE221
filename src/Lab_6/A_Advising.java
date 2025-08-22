package Lab_6;

import java.io.*;
import java.util.*;

public class A_Advising {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] line2 = br.readLine().split(" ");
            int u = Integer.parseInt(line2[0]);
            int v = Integer.parseInt(line2[1]);
            adjlist.get(u).add(v);
        }
        ArrayList<Integer> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        boolean[] recStack = new boolean[n + 1];
        boolean hasCycle = false;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, stack, adjlist)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        while (!stack.isEmpty() && !hasCycle) {
            res.add(stack.pop());
        }

        if (res.size() == n) {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean dfs(int node, boolean[] visited, boolean[] recStack, Stack<Integer> st,
            ArrayList<ArrayList<Integer>> adjlist) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbour : adjlist.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, recStack, st, adjlist))
                    return true;
            } else if (recStack[neighbour])
                return true;
        }

        recStack[node] = false;
        st.push(node);
        return false;
    }
}
