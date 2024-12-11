package x07;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회전하는큐 {

    static int frontStart(Deque<Integer> deq, int popNum) {
        Deque<Integer> tmp = new ArrayDeque<>(deq);
        int count = 0;

        while (tmp.peek() != null && tmp.peek() != popNum) {
            tmp.poll();
            count++;
        }
        return count;
    }

    static int backStart(Deque<Integer> deq, int popNum) {
        Deque<Integer> tmp = new ArrayDeque<>(deq);
        int count = 1;

        while (tmp.peekLast() != null && tmp.peekLast() != popNum) {
            tmp.pollLast();
            count++;
        }
        return count;
    }

    static void cycleDeque(Deque<Integer> deq, boolean direction, int popNum) {
        if (direction) {
            while (deq.peek() != null && deq.peek() != popNum)
                deq.offer(deq.poll());
        } else {
            while (deq.peek() != null && deq.peek() != popNum)
                deq.offerFirst(deq.pollLast());
        }
        deq.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> mQ = new ArrayDeque<>();
        while (st.hasMoreTokens())
            mQ.offer(Integer.parseInt(st.nextToken()));

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i)
            deq.offer(i);

        int count = 0;
        while (!mQ.isEmpty()) {
            int popNum = mQ.poll();

            int frontCount = frontStart(deq, popNum);
            int backCount = backStart(deq, popNum);
            if (frontCount < backCount) {
                count += frontCount;
                cycleDeque(deq, true, popNum);
            } else {
                count += backCount;
                cycleDeque(deq, false, popNum);
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
