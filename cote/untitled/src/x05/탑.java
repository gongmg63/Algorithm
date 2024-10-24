package x05;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 탑 {

    static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        Deque<Pair> stack = new ArrayDeque<>();

        int index = 0;
        StringBuilder sb = new StringBuilder();

        // 첫번째 탑
        stack.offerLast(new Pair(Integer.parseInt(st.nextToken()), index++));
        sb.append(0 + " ");

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            Pair p = new Pair(num, index++);
            Pair top = stack.pollLast();
            while (!stack.isEmpty() && top.x < p.x)
                top = stack.pollLast();
            if (top.x < p.x)
                sb.append(0 + " ");
            else {
                stack.offerLast(top);
                sb.append(top.y + 1).append(" ");
            }
            stack.offerLast(p);
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
