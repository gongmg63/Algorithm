package x14;

import java.io.*;
import java.util.StringTokenizer;

//부분합
public class p1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0,end = 0;
        int sum = 0;
        int ret = 0;
        while (end < n) {
            sum += arr[end];
            if (sum < m)
                ++end;
            else {
                if (ret == 0 || ret > end - start + 1)
                    ret = end - start + 1;
                sum -= arr[start] + arr[end];
                ++start;
            }
        }
        bw.write(ret + "\n");

        br.close();
        bw.close();
    }
}
