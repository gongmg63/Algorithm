package x03;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StrFry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] arr = new int[26];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            String base = st.nextToken();
            String compareString = st.nextToken();
            int flag = 0;

            if (base.length() != compareString.length())
                flag = 1;

            for (int j = 0; j < base.length(); ++j)
                ++arr[base.charAt(j) - 97];

            for (int j = 0; j < compareString.length(); ++j) {
                if (--arr[compareString.charAt(j) - 97] < 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                bw.write("Possible\n");
            else
                bw.write("Impossible\n");
            Arrays.fill(arr, 0);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
