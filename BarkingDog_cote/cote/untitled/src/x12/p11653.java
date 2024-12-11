package x12;

import java.io.*;

//소인수분해
public class p11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int tmp = n;
        for (int i = 2; i <= n; ++i) {
            if (tmp == 1)
                break;
            while (tmp % i == 0) {
                bw.write(i + "\n");
                tmp /= i;
            }
        }

        bw.close();
        br.close();
    }
}
