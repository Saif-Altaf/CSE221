package Lab_2;

import java.io.*;

public class LongestSubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = read.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        long k = Long.parseLong(line1[1]); // Use long to prevent overflow
        int[] arr = new int[n];
        String[] line2 = read.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }

        int maxLength = 0;
        int i = 0;
        long currentSum = 0;

        for (int j = 0; j < n; j++) {
            currentSum += arr[j];

            while (currentSum > k && i <= j) {
                currentSum -= arr[i];
                i++;
            }

            if (currentSum <= k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        System.out.println(maxLength);
    }
}