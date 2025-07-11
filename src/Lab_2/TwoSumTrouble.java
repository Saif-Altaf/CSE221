package Lab_2;

import java.io.*;

public class TwoSumTrouble {
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = read.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        long target = Long.parseLong(line1[1]);
        String[] line2 = read.readLine().split(" ");
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(line2[i]);
        }

        int left = 1, right = arr.length;
        while (left < right) {
            long sum = (long) arr[left - 1] + arr[right - 1];
            if (sum == target) {
                System.out.print(left + " " + right);
                return;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(-1);
    }

}