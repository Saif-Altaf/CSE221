package Lab_6;

import java.io.*;
import java.util.*;

public class D_Diameter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        int a = bfs(1, adjList, dis, q); // Find farthest node from node 1
        int[] dis2 = new int[n + 1];
        Arrays.fill(dis2, -1);
        int b = bfs(a, adjList, dis2, q); // Find farthest node from node a
        System.out.println(dis2[b]); // Print diameter length
        System.out.println(a + " " + b); // Print end points
    }

    public static int bfs(int source, ArrayList<ArrayList<Integer>> adjlist, int[] dis, Queue<Integer> q) {
        dis[source] = 0;
        q.add(source);
        int maxDist = 0;
        int farthestNode = source;

        while (!q.isEmpty()) {
            int curr = q.poll();
            // Only process neighbors of current node
            for (int neighbour : adjlist.get(curr)) {
                if (dis[neighbour] == -1) {
                    dis[neighbour] = dis[curr] + 1;
                    q.add(neighbour);
                    if (dis[neighbour] > maxDist) {
                        maxDist = dis[neighbour];
                        farthestNode = neighbour;
                    }
                }
            }
        }
        return farthestNode;
    }
}
