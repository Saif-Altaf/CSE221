package Lab_4;

import java.io.*;

public class GraphMetamorphosis {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(r.readLine());
        int[][] matrix = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            String[] line = r.readLine().split(" ");
            int edge = Integer.parseInt(line[0]);
            if (edge == 0) {
                continue;
            } else if (edge == 1) {
                matrix[i][Integer.parseInt(line[1])] = 1;
            } else {
                for (int j = 0; j < edge; j++) {
                    matrix[i][Integer.parseInt(line[j + 1])] = 1;
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
