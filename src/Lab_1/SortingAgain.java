package Lab_1;

import java.util.*;

public class SortingAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] id = new int[n];
        int[] marks = new int[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            id[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[maxIndex] < marks[j]) {
                    maxIndex = j;
                } else if (marks[maxIndex] == marks[j]) {
                    if (id[j] < id[maxIndex]) {
                        maxIndex = j;
                    }
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                int tempId = id[i];
                id[i] = id[maxIndex];
                id[maxIndex] = tempId;
                swaps++;
            }
        }

        System.out.println("Minimum swaps: " + swaps);
        for (int i = 0; i < n; i++) {
            System.out.println("ID: " + id[i] + " Mark: " + marks[i]);
        }
        sc.close();
    }
}
