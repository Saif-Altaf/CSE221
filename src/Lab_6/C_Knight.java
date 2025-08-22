package Lab_6;

import java.io.*;
import java.util.*;

public class C_Knight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int x1 = Integer.parseInt(line[0]);
        int y1 = Integer.parseInt(line[1]);
        int x2 = Integer.parseInt(line[2]);
        int y2 = Integer.parseInt(line[3]);
        // Define knight's moves
        int[] dx = { 2, 2, -2, -2, -1, 1, -1, 1 };
        int[] dy = { -1, 1, 1, -1, 2, 2, -2, -2 };

        // Initialize distance array
        int[][] dis = new int[n + 1][n + 1];
        for (int[] row : dis) {
            Arrays.fill(row, -1);
        }

        System.out.println(bfs(x1, y1, x2, y2, n, dx, dy, dis));
    }

    public static int bfs(int startX, int startY, int targetX, int targetY, int n, int[] dx, int[] dy, int[][] dis) {
        // If start and target are same
        if (startX == targetX && startY == targetY)
            return 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { startX, startY });
        dis[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            // Try all possible knight moves
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check if move is valid and cell is not visited
                if (isValid(newX, newY, n) && dis[newX][newY] == -1) {
                    dis[newX][newY] = dis[x][y] + 1;
                    q.add(new int[] { newX, newY });

                    // If target is reached
                    if (newX == targetX && newY == targetY) {
                        return dis[newX][newY];
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int n) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
}
