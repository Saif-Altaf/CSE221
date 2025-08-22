package Lab_6;

import java.util.*;
import java.io.*;

public class E_AncientOrdering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().trim();
        }

        // Graph for 26 letters
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[26];
        boolean[] seen = new boolean[26]; // track which letters actually appear

        // Mark letters that appear
        for (String w : words) {
            for (char c : w.toCharArray()) {
                seen[c - 'a'] = true;
            }
        }

        // Build graph constraints
        boolean valid = true;
        for (int i = 0; i < N - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean foundDiff = false;

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    indegree[c2 - 'a']++;
                    foundDiff = true;
                    break;
                }
            }
            // Prefix case invalid
            if (!foundDiff && w1.length() > w2.length()) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            System.out.println(-1);
            return;
        }

        // Lexicographically smallest topological sort
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (seen[i] && indegree[i] == 0) pq.add(i);
        }

        StringBuilder order = new StringBuilder();
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            order.append((char) (curr + 'a'));
            for (int nxt : adj.get(curr)) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) pq.add(nxt);
            }
        }

        // Check if we included all seen letters
        for (int i = 0; i < 26; i++) {
            if (seen[i] && order.indexOf("" + (char) (i + 'a')) == -1) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(order.toString());
    }
}
