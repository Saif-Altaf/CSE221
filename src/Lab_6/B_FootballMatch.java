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

        Queue<Integer> q = new LinkedList<>();
        int color[] = new int[n + 1];
        Arrays.fill(color, -1);
        int result = 0;
        boolean possible = true;

        for (int i = 1; i <= n && possible; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                int count0 = 1, count1 = 0;

                while (!q.isEmpty() && possible) {
                    int curr = q.poll();
                    for (int neighbor : adjlist.get(curr)) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[curr];
                            if (color[neighbor] == 0)
                                count0++;
                            else
                                count1++;
                            q.add(neighbor);
                        } else if (color[neighbor] == color[curr]) {
                            possible = false;
                            break;
                        }
                    }
                }

                if (possible) {
                    result += Math.max(count0, count1);
                }
            }
        }

        System.out.println(possible ? result : 0);
    }
}
