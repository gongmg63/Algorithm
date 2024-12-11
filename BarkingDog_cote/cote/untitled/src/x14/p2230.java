package x14;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//수 고르기
public class p2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        while (end < n) {
            int minus = arr[end] - arr[start];
            if (minus < m)
                ++end;
            else {
                if (min > minus) {
                    min = minus;
                    if (min == m)
                        break;
                }
                ++start;
            }
        }
        bw.write(min + "\n");

        br.close();
        bw.close();
    }
}
