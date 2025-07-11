package Lab_2;

import java.io.*;

public class CountTheNumbers {
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = read.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int q = Integer.parseInt(line1[1]);
        String[] line2 = read.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }

        for (int i = 0; i < q; i++) {
            String[] line3 = read.readLine().split(" ");
            int q1 = Integer.parseInt(line3[0]);
            int q2 = Integer.parseInt(line3[1]);
            int leftIdx = lowerBound(arr, q1);
            int rightIdx = upperBound(arr, q2);
            int count = (leftIdx <= rightIdx) ? (rightIdx - leftIdx + 1) : 0;
            System.out.println(count);
        }
    }

    private static int lowerBound(int[] arr, int value) {
        int left = 0, right = arr.length - 1, ans = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= value) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] arr, int value) {
        int left = 0, right = arr.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= value) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
