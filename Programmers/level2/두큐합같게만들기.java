package level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

public class 두큐합같게만들기 {
    class Solution {
        public static int solution(int[] queue1, int[] queue2) { // 두 큐의 합을 같게 만들기
            int answer = 0;

            Queue<Integer> q1 = new ArrayDeque<>(
                    Arrays.stream(queue1)
                            .boxed()
                            .collect(Collectors.toList())
            );

            Queue<Integer> q2 = new ArrayDeque<>(
                    Arrays.stream(queue2)
                            .boxed()
                            .collect(Collectors.toList())
            );

            long q1Sum = Arrays.stream(queue1).sum();
            long q1OriginalSum = q1Sum;
            long q2Sum = Arrays.stream(queue2).sum();
            if ((q1Sum + q2Sum) % 2 == 1)
                return -1;

            while (q1Sum != q2Sum) {
                if (q1Sum > q2Sum) {
                    int num = q1.poll();
                    q2.offer(num);
                    q1Sum -= num;
                    q2Sum += num;
                }
                else {
                    int num = q2.poll();
                    q1.offer(num);
                    q1Sum += num;
                    q2Sum -= num;
                }
                ++answer;
                if (answer > queue1.length * 4)
                    return -1;
            }
            return answer;
        }
    }
}

