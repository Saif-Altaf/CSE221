package Lab_1;

import java.util.*;

public class ArithmeticExpressions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str= sc.next();
            double num1 = sc.nextDouble();
//            sc.nextLine();
            String operation = sc.next();
            double num2 = sc.nextDouble();
            if (operation.equals("+")) {
                System.out.println(num1 + num2);
            }
            if (operation.equals("-")) {
                System.out.println(num1 - num2);
            }
            if (operation.equals("*")) {
                System.out.println((num1 * num2));
            }
            if (operation.equals("/")) {
                System.out.println(num1 / num2);
            }
        }
        sc.close();
    }
}
