//package Lab_5;
//
//import java.io.*;
//import java.util.*;
//
//public class Test {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] line1 = br.readLine().split(" ");
//        int n = Integer.parseInt(line1[0]);
//        int m = Integer.parseInt(line1[1]);
//
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            list.add(new ArrayList<>());
//        }
//        for (int i = 0; i < m; i++) {
//            String[] line2 = br.readLine().split(" ");
//            int u = Integer.parseInt(line2[0]);
//            int v = Integer.parseInt(line2[1]);
//            list.get(u).add(v);
//        }
//
//        Stack<Integer> st = new Stack<>();
//        boolean[] vis = new boolean[n + 1];
//        boolean[] restack = new boolean[n + 1];
//        boolean hasCycle = true;
//
//        for (int i = 1; i <= n; i++) {
//            if (!vis[i]) {
//                if (dfs(i, st, vis, restack, list)) ;
//            }
//        }
//    }
//
//    public static boolean dfs(int sr, Stack<Integer> st, boolean[] vis, boolean[] restack, ArrayList<ArrayList<Integer>> list) {
//        vis[sr] = true;
//        restack[sr] = true;
//        for (int neigh : list.get(sr)) {
//            if (!vis[neigh]) {
//                if (dfs(neigh))
//            }
//        }
//    }
//}
