package Lab_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderingBinaryTree {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        String[] line = read.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(line[i]);
        }
//        int n = 5;
//        long[] arr ={1, 2, 3, 4, 5};
        int mid = n / 2;
        build(arr, mid);
    }

    public static void build(long[] arr, int mid) {
        if (arr.length == 2) {
            System.out.print( arr[mid-1]+ " "+arr[mid]+" ");
            return;
        }
        if (arr.length == 0) {
            return;
        }
        System.out.print(arr[mid] + " ");

        long[] subLeft = new long[mid];
        for (int i = 0; i < mid; i++) {
            subLeft[i] = arr[i];
        }
        long[] subRight = new long[arr.length - (mid+1)];
        for (int i = mid + 1; i < arr.length; i++) {
            subRight[i - (mid+1)] = arr[i];
        }
        build(subLeft, subLeft.length / 2);
        build(subRight, subRight.length / 2);
    }
}
