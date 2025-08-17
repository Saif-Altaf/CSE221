package Lab_5;

import java.io.*;
import java.util.*;

public class A_CanyouTraverse1 {
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

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList.get(u).add(new Edge(v));
            adjList.get(v).add(new Edge(u));
        }

        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (Edge edge : adjList.get(current)) {
                int neighbor = edge.des;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println(sb.toString());
    }
}