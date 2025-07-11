package Lab_1;

import java.util.*;

public class IsSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            boolean yes = true;
            int size = sc.nextInt();
            int prev = 0;
            for (int j = 0; j < size; j++) {
                int current = sc.nextInt();
                if (!(current >= prev)) {
                    yes = false;
                }
                prev = current;
            }
            if (yes) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
