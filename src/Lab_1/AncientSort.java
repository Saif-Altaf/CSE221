package Lab_1;

import java.util.*;

public class AncientSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean possible = true;
        while (possible) {
            int swaps = 0;
            int p1 = 0;
            int p2 = 1;
            while (p1 < arr.length - 1 && p2 < arr.length) {
                if ((arr[p1] > arr[p2] && arr[p1] % 2 == 0 && arr[p2] % 2 == 0) || (arr[p1] > arr[p2] && arr[p1] % 2 != 0 && arr[p2] % 2 != 0)) {
                    int temp = arr[p1];
                    arr[p1] = arr[p2];
                    arr[p2] = temp;
                    swaps++;
                }
                p1++;
                p2++;
            }
            if (swaps == 0) {
                possible = false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
