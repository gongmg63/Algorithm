package x15;

import java.io.*;
import java.util.*;

//회사에 있는 사람
public class p7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            if (!set.contains(name))
                set.add(name);
            else
                set.remove(name);
        }

        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        for (String s : list)
            bw.write(s + "\n");
        br.close();
        bw.close();
    }
}
