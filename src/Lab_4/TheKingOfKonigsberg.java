package Lab_4;

import java.io.*;

public class TheKingOfKonigsberg {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String[] positions = r.readLine().split(" ");
        int x = Integer.parseInt(positions[0]);
        int y = Integer.parseInt(positions[1]);

        int moves = 0;

        int a, b;
        int[] arrX = new int[8];
        int[] arrY = new int[8];
        int i = 0;
        a = x - 1;
        b = y - 1;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        a = x - 1;
        b = y;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        a = x - 1;
        b = y + 1;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        a = x;
        b = y - 1;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        a = x;
        b = y + 1;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        a = x + 1;
        b = y - 1;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        a = x + 1;
        b = y;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        a = x + 1;
        b = y + 1;
        if (a >= 1 && a <= n && b >= 1 && b <= n) {
            arrX[i] = a;
            arrY[i] = b;
            moves++;
            i++;
        }

        System.out.println(moves);
        for (int j = 0; j < moves; j++) {
            if (arrX[j] != 0 && arrY[j] != 0) {
                System.out.println(arrX[j] + " " + arrY[j]);
            }
        }
    }
}