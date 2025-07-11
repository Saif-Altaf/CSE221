package Lab_2;
import java.io.*;

public class BeautifulSortedList {
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        String[] line1 = read.readLine().split(" ");
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(line1[i]);
        }

        int m = Integer.parseInt(read.readLine());
        String[] line2 = read.readLine().split(" ");
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(line2[i]);
        }

        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();
        while (i < n && j < m) {
            if (arrN[i] <= arrM[j]) {
                result.append(arrN[i]).append(" ");
                i++;
            } else {
                result.append(arrM[j]).append(" ");
                j++;
            }
        }

        if (i < n) {
            for (int k = i; k < n; k++) {
                result.append(arrN[k]).append(" ");
            }
        } else if (j < m) {
            for (int k = j; k < m; k++) {
                result.append(arrM[k]).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}