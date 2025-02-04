package level2;

import java.util.ArrayList;

public class 줄서는방법 {

    long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; ++i)
            result *= i;
        return result;
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; ++i)
            numList.add(i);

        int index = 0;
        while (!numList.isEmpty()) {
            long num = factorial(--n);

            int location = (int)(k / num);
            if (k % num == 0)
                location -= 1;
            k -= location * num;

            answer[index++] = numList.remove(location);
        }
        return answer;
    }
}
