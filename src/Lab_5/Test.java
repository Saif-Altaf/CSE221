package Lab_5;

import java.io.*;
import java.util.*;

public class Test {
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
        int r = Integer.parseInt(arr[1]);
        int[][] matrix = new int[n + 1][n + 1];

        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int source = Integer.parseInt(line[0]);
            int destination = Integer.parseInt(line[1]);
            matrix[source][destination] = 1;
        }

        int Q = 3;
        for (int i = 0; i < Q; i++) {
            int count = 1;
            int s = Integer.parseInt(br.readLine());
            for (int row = 1; row < matrix.length; row++) {
                if (matrix[row][s] == 1 || row == s) {
                    for (int col = 1; col < matrix[0].length; col++) {
                        if (matrix[row][col] == 1) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
