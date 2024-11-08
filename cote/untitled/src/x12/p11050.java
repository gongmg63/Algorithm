package x12;

import java.io.*;
import java.util.StringTokenizer;

// 이항계수1
public class p11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[11][11];

        // nCk = n-1Ck + n-lCk-1
        for (int i = 1; i <= n; ++i) {
            arr[i][0] = arr[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        bw.write(arr[n][k] + "\n");

        bw.close();
        br.close();
    }
}
