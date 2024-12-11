package x10;

import java.io.*;

public class 이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[90];

        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; ++i)
            arr[i] = arr[i - 1] + arr[i - 2];
        bw.write(arr[n - 1] + "\n");

        bw.close();
        br.close();
    }
}
