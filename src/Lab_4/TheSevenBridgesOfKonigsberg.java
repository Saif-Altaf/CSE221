package Lab_4;

import java.io.*;

public class TheSevenBridgesOfKonigsberg {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = r.readLine().split(" ");
        int nodes = Integer.parseInt(line1[0]);
        int edges = Integer.parseInt(line1[1]);
        String[] line2 = r.readLine().split(" ");
        String[] line3 = r.readLine().split(" ");
        int[] source = new int[edges];
        int[] destination = new int[edges];
        for (int i = 0; i < edges; i++) {
            source[i] = Integer.parseInt(line2[i]);
            destination[i] = Integer.parseInt(line3[i]);
        }

        int[] degree = new int[nodes + 1];
        for (int i = 0; i < edges; i++) {
            degree[source[i]]++;
            degree[destination[i]]++;
        }

        int count = 0;
        for (int i = 1; i <= nodes; i++) {
            if (degree[i] % 2 != 0) {
                count++;
            }
        }

        if (count == 0 || count == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
