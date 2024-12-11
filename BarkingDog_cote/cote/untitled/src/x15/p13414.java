package x15;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

//수강신청
public class p13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> set = new LinkedHashSet<>(); // 삽입 순서 유지
        for (int i = 0; i < k; ++i) {
            int num = Integer.parseInt(br.readLine());

            if (set.contains(num)) {
                set.remove(num);
                set.add(num);
            } else
                set.add(num);
        }

        for (Integer num : set) {
            if (n-- == 0)
                break;
            if (num.toString().length() < 8) {
                for (int i = 0; i < 8 - num.toString().length(); ++i)
                    bw.write("0");
            }
            bw.write(num + "\n");
        }
        br.close();
        bw.close();
    }
}
