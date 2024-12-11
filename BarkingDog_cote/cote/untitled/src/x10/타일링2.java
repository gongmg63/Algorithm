package x10;

import java.io.*;

public class 타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000];

        arr[0] = 1;
        arr[1] = 3;
        for (int i = 2; i < n; ++i)
            arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
        bw.write(arr[n - 1] + "\n");

        bw.close();
        br.close();
    }
}
