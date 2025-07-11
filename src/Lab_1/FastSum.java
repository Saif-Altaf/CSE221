package Lab_1;

import java.util.*;

public class FastSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long num = sc.nextInt();
            System.out.println(num * (num + 1) / 2);
        }
        sc.close();
    }
}
