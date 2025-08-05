//package Lab_3;
//
//import java.io.*;
//
//public class CountTheInversionRevisited {
//    public static long count;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(reader.readLine());
//        String[] line = reader.readLine().split(" ");
//        long[] arr = new long[size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = Math.abs(Long.parseLong(line[i]));
//        }
////        long[] arr = {10, 2, 5, 1, 2, 25};
//        mergeSort(arr);
//        System.out.println(count);
//    }
//
//    public static void mergeSort(long[] arr) {
//        if (arr.length < 2) {
//            return;
//        }
//        int mid = arr.length / 2;
//
//        long[] sub1 = new long[mid];
//        for (int i = 0; i < mid; i++) {
//            sub1[i] = arr[i];
//        }
//
//        long[] sub2 = new long[arr.length - mid];
//        for (int i = mid; i < arr.length; i++) {
//            sub2[i - mid] = arr[i];
//        }
//
//        mergeSort(sub1);
//        mergeSort(sub2);
//        merge(sub1, sub2, arr);
//    }
//
//    public static void merge(long[] sub1, long[] sub2, long[] arr) {
//        int i = 0, j = 0, k = 0;
//        while (i < sub1.length && j < sub2.length) {
//            if (sub1[i] >= sub2[j]) {
//                arr[k++] = sub1[i++];
//            } else {
//                arr[k++] = sub2[j++];
//            }
//        }
//        while (i < sub1.length) {
//            arr[k++] = sub1[i++];
//        }
//        while (j < sub2.length) {
//            arr[k++] = sub2[j++];
//        }
//        i = sub1.length - 1;
//        j = 0;
//        while (i >= 0 && j < sub2.length) {
//            if (sub1[i] > sub2[j]) {
//                if (sub1[i] > sub2[j] * sub2[j]) {
//                    count += sub1.length - ((sub1.length - 1) - i);
//                    j++;
//                } else {
//                    i--;
//                }
//            } else {
//                j++;
//            }
//        }
//
//        }
//    }
