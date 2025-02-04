package x0B;

import java.io.*;

public class 하노이탑이동순서 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void hanoi(int a, int b, int n) throws IOException {
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return ;
        }
        hanoi(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        hanoi(6 - a - b, b, n - 1);
    }

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        bw.write((int)Math.pow(2, n) - 1 + "\n");
        hanoi(1, 3, n);
        bw.flush();
        bw.close();
        br.close();
    }
}
