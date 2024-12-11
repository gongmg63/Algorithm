package x12;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//GCD의 합
public class p9613 {
    // gcd -> a % b = r, b % r = r2 ... r == 0, a 가 gcd
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0;i < n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            long ret = 0;

            while (st.hasMoreTokens())
                list.add(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < list.size(); ++j) {
                for (int k = j + 1; k < list.size(); ++k) {
                    ret += gcd(list.get(j), list.get(k));
                }
            }
            list.clear();
            bw.write(ret + "\n");
        }

        br.close();
        bw.close();
    }
}
