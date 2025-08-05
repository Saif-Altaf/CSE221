package Lab_3;

import java.io.*;

public class FastSeriesDrift {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(read.readLine());
        for (int i = 0; i < test; i++) {
            String[] line = read.readLine().split(" ");
            long a = Integer.parseInt(line[0]);
            long n = Integer.parseInt(line[1]);
            long m = Integer.parseInt(line[2]);
            System.out.println(seriesSum(a, n, m));
        }
    }

    public static long seriesSum(long a, long n, long m) {
        if (a == 1) {
            return n % m;
        }
        if (n == 1) {
            return a % m;
        }
        if (n == 0) {
            return 0;
        }
        long halfSum = sum(a, n / 2);
        if (n % 2 == 0) {
            return (long) ((halfSum * (1 + Math.pow(a, n / 2))) % m);
        } else {
            return (long) ((halfSum * (1 + Math.pow(a, n / 2)) + Math.pow(a, n)) % m);
        }
    }

    private static long sum(long a, long n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.pow(a, i);
        }
        return sum;
    }
}
