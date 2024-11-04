package x10;

import java.io.*;
import java.util.StringTokenizer;

public class 정수삼각형 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[125250];
        int[] max = new int[125250];
        arr[0] = Integer.parseInt(br.readLine());
        max[0] = arr[0];

        int count = 1;
        for (int i = 2; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; ++j) {
                arr[count] = Integer.parseInt(st.nextToken());
                if (i == n)
                    max[count] = arr[count];
                ++count;
            }
        }

        count -= n + 1; //마지막 층 이전 층의 마지막 위치
        for (int i = n - 1; i >= 0; --i) { // i는 현재 층
            for (int j = 0; j < i; ++j) {
                max[count] = Math.max(arr[count] + max[count + i], arr[count] + max[count + i + 1]);
                --count;
            }
        }
        bw.write(max[0] + "\n");

        br.close();
        bw.close();
    }
}
