package Lab_5;

import java.io.*;
import java.util.*;

public class E_EasyTreeQueries {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] first = br.readLine().split(" ");
    int N = Integer.parseInt(first[0]);
    int R = Integer.parseInt(first[1]);

    ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    for (int i = 0; i <= N; i++)
      tree.add(new ArrayList<>());

    for (int i = 0; i < N - 1; i++) {
      String[] edge = br.readLine().split(" ");
      int u = Integer.parseInt(edge[0]);
      int v = Integer.parseInt(edge[1]);
      tree.get(u).add(v);
      tree.get(v).add(u);
    }

    int[] subtreeSize = new int[N + 1];
    boolean[] visited = new boolean[N + 1];
    dfs(R, tree, subtreeSize, visited);

    int Q = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < Q; i++) {
      int X = Integer.parseInt(br.readLine());
      System.out.println(subtreeSize[X]);
    }

  }

  static int dfs(int node, ArrayList<ArrayList<Integer>> tree, int[] subtreeSize, boolean[] visited) {
    visited[node] = true;
    int size = 1;
    for (int child : tree.get(node)) {
      if (!visited[child]) {
        size += dfs(child, tree, subtreeSize, visited);
      }
    }
    subtreeSize[node] = size;
    return size;
  }
}
