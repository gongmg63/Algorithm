package x0C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {
    static boolean[] isVisited = new boolean[8];
    static int[] arr = new int[8];
    static int[] retArr = new int[8];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void backTracking(int n, int m, int depth) throws IOException{
        if (depth == m) {
            for (int i = 0; i < m; ++i)
                bw.write(retArr[i] + " ");
            bw.write("\n");
        }
        for (int i = 0; i < n; ++i) {
            if (!isVisited[i]) {
                retArr[depth] = arr[i];
                isVisited[i] = true;
                backTracking(n, m, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 8; ++i)
            arr[i] = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        backTracking(n, m, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}
