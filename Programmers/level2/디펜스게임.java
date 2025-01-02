package level2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int j : enemy) {
            if (n < j && k == 0)
                break;
            ++answer;
            pq.offer(j);
            if (n < j) {
                --k;
                n += pq.poll();
            }
            n -= j;
        }
        return answer;
    }
}
