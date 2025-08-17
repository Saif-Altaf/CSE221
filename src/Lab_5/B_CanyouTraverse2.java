package Lab_5;

import java.io.*;
import java.util.*;

public class B_CanyouTraverse2 {
    static class Edge {
        int des;

        public Edge(int des) {
            this.des = des;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        String[] src = br.readLine().split(" ");
        String[] des = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(src[i]);
            int b = Integer.parseInt(des[i]);
            adjList.get(a).add(new Edge(b));
            adjList.get(b).add(new Edge(a));
        }

        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;

            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                int current = stack.pop();
                if (!visited[current]) {
                    visited[current] = true;
                    sb.append(current).append(" ");

                    for (Edge edge : adjList.get(current)) {

                        int neighbor = edge.des;
                        if (!visited[neighbor]) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}