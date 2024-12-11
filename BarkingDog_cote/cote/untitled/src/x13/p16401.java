package x13;

import java.io.*;
import java.util.StringTokenizer;

//과자 나눠주기
public class p16401 {

    static int binarySearch(int[] arr, int m, int max) {
        int st = 1, end = max, ret = 0;

        while (st <= end) {
            int slice = 0;

            int mid = (st + end) / 2;
            for (int j : arr)
                slice += j / mid;
            if (slice >= m)
                st = mid + 1;
            else
                end = mid - 1;

            if (slice >= m && mid > ret)
                ret = mid;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max)
                max = arr[i];
        }

        bw.write(binarySearch(arr, m, max) + "\n");

        bw.close();
        br.close();
    }
}
