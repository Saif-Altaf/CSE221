package Lab_2;

import java.io.*;

public class LongestKDistanceSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = read.readLine().split(" ");
        int size = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        String[] line2 = read.readLine().split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }

        int[] count = new int[size + 1];

        int i = 0, maxLength = 0, distinct = 0;
        for (int j = 0; j < size; j++) {
            if (count[arr[j]] == 0) {
                distinct++;
            }
            count[arr[j]]++;

            while (i <= j && distinct > k) {
                count[arr[i]] -= 1;
                if (count[arr[i]] < 1) {
                    distinct--;
                }
                i++;
            }

            maxLength = Math.max(maxLength, (j - i) + 1);
        }
        System.out.println(maxLength);
    }
}
