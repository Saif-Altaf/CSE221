package Lab_2;
import java.io.*;

public class BeautifulSortedList {
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int sizeN = Integer.parseInt(read.readLine());
        String[] line1 = read.readLine().split(" ");
        int[] arrN = new int[sizeN];
        for (int i = 0; i < sizeN; i++) {
            arrN[i] = Integer.parseInt(line1[i]);
        }

        int sizeM = Integer.parseInt(read.readLine());
        String[] line2 = read.readLine().split(" ");
        int[] arrM = new int[sizeM];
        for (int i = 0; i < sizeM; i++) {
            arrM[i] = Integer.parseInt(line2[i]);
        }

        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();
        while (i < sizeN && j < sizeM) {
            if (arrN[i] <= arrM[j]) {
                result.append(arrN[i]).append(" ");
                i++;
            } else {
                result.append(arrM[j]).append(" ");
                j++;
            }
        }

        if (i < sizeN) {
            for (int k = i; k < sizeN; k++) {
                result.append(arrN[k]).append(" ");
            }
        } else if (j < sizeM) {
            for (int k = j; k < sizeM; k++) {
                result.append(arrM[k]).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}