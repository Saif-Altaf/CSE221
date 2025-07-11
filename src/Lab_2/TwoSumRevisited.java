package Lab_2;

import java.util.Scanner;

public class TwoSumRevisited {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] arrA = new int[n], arrB = new int[m];

        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = sc.nextInt();
        }

        int i = 1, j = arrB.length, index1 = 1, index2 = arrB.length;
        int closest = Math.abs(arrA[i - 1] + arrB[j - 1] - k);

        while (i <= arrA.length && j > 0) {
            if (Math.abs(arrA[i - 1] + arrB[j - 1] - k) < closest) {
                closest = Math.abs(arrA[i - 1] + arrB[j - 1] - k);
                index1 = i;
                index2 = j;
            }
            int sum = arrA[i - 1] + arrB[j - 1];
            if (sum == k) {
                System.out.print(i + " " + j);
                return;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        
        System.out.print(index1 + " " + index2);
        sc.close();
    }
}
