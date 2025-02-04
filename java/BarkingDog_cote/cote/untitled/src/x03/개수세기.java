package x03;

import java.io.*;
import java.util.StringTokenizer;

public class 개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (v == Integer.parseInt(st.nextToken()))
                ++count;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
        return ;
    }
}
