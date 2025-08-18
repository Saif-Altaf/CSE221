package Lab_5;

import java.io.*;
import java.util.*;

public class G_Diamonds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][H];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[R][H];
        int maxDiamonds = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < H; j++) {
                if (!visited[i][j] && grid[i][j] != '#') {
                    int diamonds = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cell = q.poll();
                        int x = cell[0], y = cell[1];
                        if (grid[x][y] == 'D') diamonds++;

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < R && ny >= 0 && ny < H &&
                                    !visited[nx][ny] && grid[nx][ny] != '#') {
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }

                    maxDiamonds = Math.max(maxDiamonds, diamonds);
                }
            }
        }

        System.out.println(maxDiamonds);
    }
}
