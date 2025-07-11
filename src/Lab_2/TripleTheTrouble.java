package Lab_2;

import java.io.*;
import java.util.Arrays;

public class TripleTheTrouble {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = read.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        long target = Long.parseLong(line1[1]);
        String[] line2 = read.readLine().split(" ");
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(line2[i]);
        }

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i+1);
        }
        Arrays.sort(pairs, (a, b) -> Long.compare(a.value, b.value));

        for (int i = 0; i < n; i++) {
            int y = i + 1, z = n - 1;
            while (y < z) {
                long sum = pairs[i].value + pairs[y].value + pairs[z].value;
                if (sum == target) {
                    System.out.println(pairs[i].index + " " + pairs[y].index + " " + pairs[z].index);
                    return;
                } else if (sum < target) {
                    y++;
                } else {
                    z--;
                }
            }
        }
        System.out.println(-1);
    }
}

class Pair {

    public long value;
    public int index;

    public Pair(Long value, int index) {
        this.value = value;
        this.index = index;
    }
}
