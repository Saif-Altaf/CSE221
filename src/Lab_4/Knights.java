package Lab_4;

import java.io.*;

public class Knights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read first line: N, M, K
        String[] firstLine = br.readLine().trim().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int K = Integer.parseInt(firstLine[2]);

        // Create 2D boolean array to mark knight positions (1-based indexing)
        boolean[][] board = new boolean[N + 1][M + 1];

        // Read and store knight positions
        int[][] knights = new int[K][2];
        for (int i = 0; i < K; i++) {
            String[] pos = br.readLine().trim().split(" ");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            knights[i][0] = x;
            knights[i][1] = y;
            board[x][y] = true;
        }

        // Possible knight moves: {dx, dy}
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

        // Check each knight
        for (int i = 0; i < K; i++) {
            int x = knights[i][0];
            int y = knights[i][1];

            // Check all possible moves
            for (int j = 0; j < 8; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                // Ensure destination is within board and has a knight
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && board[nx][ny]) {
                    System.out.println("YES");
                    br.close();
                    return;
                }
            }
        }

        System.out.println("NO");
        br.close();
    }
}
