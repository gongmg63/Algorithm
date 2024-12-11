package x06;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i)
            q.add(i);

        // 제일 위 버리기 -> 제일 위 아래로 내리기
        for (int i = 0; i < n - 1; ++i) {
            q.poll();
            q.add(q.poll());
        }
        bw.write(q.poll() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
