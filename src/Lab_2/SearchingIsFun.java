package Lab_2;

import java.io.*;

public class SearchingIsFun {

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        for (int i = 0; i < t; i++) {
            String[] line = read.readLine().split(" ");
            long pos = Long.parseLong(line[0]);
            long divisor = Long.parseLong(line[1]);
            System.out.println(((pos * divisor) - 1) / (divisor - 1));
        }
    }
}
