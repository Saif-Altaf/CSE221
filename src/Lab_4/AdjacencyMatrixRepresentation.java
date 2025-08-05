package Lab_4;

import java.io.*;

public class AdjacencyMatrixRepresentation {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = read.readLine().split(" ");
        int nodes = Integer.parseInt(line1[0]);
        int vertex = Integer.parseInt(line1[1]);
        int[][] matrix = new int[nodes + 1][nodes + 1];
        for (int i = 0; i < vertex; i++) {
            String[] line = read.readLine().split(" ");
            int source = Integer.parseInt(line[0]);
            int destination = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);
            matrix[source][destination] = weight;
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
