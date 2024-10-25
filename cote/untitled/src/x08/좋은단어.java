package x08;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; ++i) {
            String str = br.readLine();

            if (str.length() % 2 != 0)
                continue;

            Deque<Character> deq = new ArrayDeque<>();
            int j = 0;
            for ( ; j < str.length(); ++j) {
                if (deq.isEmpty())
                    deq.offer(str.charAt(j));
                else {
                    if (deq.peekLast() == str.charAt(j))
                        deq.pollLast();
                    else
                        deq.offerLast(str.charAt(j));
                }
            }
            if (deq.isEmpty())
                count++;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
