package level2;

public class 하노이탑 {
    int[][] answer;
    int idx = 0;

    void hanoi(int start, int end, int other, int num) {
        if (num == 0) return ;
        hanoi(start, other, end, num - 1);
        answer[idx][0] = start;
        answer[idx++][1] = end;
        hanoi(other, end, start, num - 1);
    }

    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n) - 1][2];
        hanoi(1, 3, 2, n);
        return answer;
    }
}
