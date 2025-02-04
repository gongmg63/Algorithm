package x0B;

import java.io.*;
import java.util.StringTokenizer;

public class 곱셈 {

    static long multiple(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = multiple(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 1)
            val = val * a % c;
        return val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(multiple(a, b, c) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
