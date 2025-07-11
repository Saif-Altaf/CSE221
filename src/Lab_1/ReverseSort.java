package Lab_1;

import java.util.*;

public class ReverseSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> arr0 = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr0.add(arr[i]);
            } else {
                arr1.add(arr[i]);
            }
        }

        Collections.sort(arr0);
        Collections.sort(arr1);

        int last = Integer.MIN_VALUE;

        for (int i = 0; i < n / 2; i++) {
            if (arr1.get(i) >= arr0.get(i) && arr0.get(i) >= last) {
                last = arr1.get(i);
            } else {
                System.out.println("No");
                return;
            }
        }

        if (n % 2 == 1 && arr0.get(arr0.size() - 1) < last) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
        sc.close();
    }
}
