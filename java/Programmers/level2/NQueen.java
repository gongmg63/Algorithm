package level2;

public class NQueen {
    int answer = 0;
    int n;
    int[] row = new int[13];

    void nQueen(int depth) {
        if (depth == n) {
            ++answer;
            return ;
        }
        for (int i = 1; i <= n; ++i) {
            row[depth + 1] = i;
            if (!promising(depth + 1)) continue;
            nQueen(depth + 1);
        }
    }

    boolean promising(int depth) {
        for (int i = 1; i <= depth; ++i) {
            if (row[i] == 0) continue;
            if (row[depth] == row[i] || row[depth] - depth == row[i] - i || row[depth] + depth == row[i] + i)
                return false;
        }

        return true;
    }

    public int solution(int pN) {
        n = pN;
        nQueen(0);
        return answer;
    }
}
