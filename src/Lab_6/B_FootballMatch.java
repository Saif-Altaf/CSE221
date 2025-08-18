package Lab_6;

import java.io.*;
import java.util.*;

public class B_FootballMatch {
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
            adjlist.get(v).add(u);
        }


        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[n + 1];
        int bipartite[] = new int[n + 1];
        Arrays.fill(bipartite, -1);
        stack.push(1);
        bipartite[1] = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                // Add neighbors to stack
                for (int neighbor : adjlist.get(curr)) {
                    if (!visited[neighbor]) {
                        if (bipartite[curr] == 0) {
                            bipartite[neighbor] = 1;
                        } else if (bipartite[curr] == 1) {
                            bipartite[neighbor] = 0;
                        }
                        stack.push(neighbor);
                    }
                }
            }
        }

        int count1 = 0;
        int count0 = 0;
        for (int i = 1; i < bipartite.length; i++) {
            if (bipartite[i] == 1) {
                count1++;
            } else {
                count0++;
            }
        }
        System.out.println(Math.max(count0, count1));
    }
}
