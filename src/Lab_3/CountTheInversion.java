package Lab_3;

import java.io.*;

public class CountTheInversion {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(read.readLine());
        String[] line = read.readLine().split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        long inversion = 0;
        inversion = mergeSort(arr, inversion);
        System.out.println(inversion);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static long mergeSort(int[] arr, long inversion) {
        if (arr.length < 2) {
            return inversion;
        }
        int mid = arr.length / 2;

        int[] subarr1 = new int[mid];
        for (int i = 0; i < mid; i++) {
            subarr1[i] = arr[i];
        }

        int[] subarr2 = new int[arr.length - mid];
        for (int i = mid; i < arr.length; i++) {
            subarr2[i - mid] = arr[i];
        }

        return mergeSort(subarr1, inversion) + mergeSort(subarr2, inversion) + merge(subarr1, subarr2, arr, inversion);
    }

    private static long merge(int[] sub1, int[] sub2, int[] arr, long inversion) {
        int i = 0, j = 0, k = 0;
        while (i < sub1.length && j < sub2.length) {
            if (sub1[i] <= sub2[j]) {
                arr[k++] = sub1[i++];
            } else {
                inversion += (sub1.length - i);
                arr[k++] = sub2[j++];
            }
        }
        while (i < sub1.length) {
            arr[k++] = sub1[i++];
        }
        while (j < sub2.length) {
            arr[k++] = sub2[j++];
        }
        return inversion;
    }
}