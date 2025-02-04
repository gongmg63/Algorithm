package x17;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//절댓값 힙
public class p11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (Math.abs(integer) == Math.abs(t1)) {
                    return Integer.compare(integer, t1);
                }
                return Integer.compare(Math.abs(integer), Math.abs(t1));
            }
        });

        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0)
                pq.add(num);
            else {
                if (pq.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(pq.poll() + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
