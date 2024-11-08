package x12;

import java.io.*;
import java.util.StringTokenizer;

//에라토스테네스의 체
public class p2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[1001];

        for (int i = 2; i <= n; ++i) {
            if (arr[i]) continue;
            arr[i] = true;
            --k;
            if (k == 0) {
                bw.write(i + "\n");
                break;
            }
            for (int j = i * i; j <= n; j += i) {
                if (arr[j]) continue;
                arr[j] = true;
                --k;
                if (k == 0) {
                    bw.write(j + "\n");
                    break;
                }
            }
        }
        br.close();
        bw.close();
    }
}
