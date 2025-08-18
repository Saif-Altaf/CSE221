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
        boolean visited[] = new boolean[n + 1];
        stack.push(2);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                res.add(curr);
                // Add neighbors to stack
                for (int neighbor : adjlist.get(curr)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        Collections.reverse(res);
        System.out.println(res);
        // if (res.size() == n) {
        // System.out.println(res);
        // } else {
        // System.out.println(-1);
        // }
    }
}
