package level2;

public class 퍼즐게임 {
    int[] diffs, times;

    double countTime(int level) {
        double ret = 0;

        for (int i = 0; i < diffs.length; ++i) {
            int diff = diffs[i];
            int time = times[i];

            if (diff > level) {
                int preTime = (i == 0 ? 0 : times[i - 1]);
                ret += (diff - level) * (time + preTime);
            }
            ret += time;
        }
        return ret;
    }

    int binarySearch(long limit) {
        int start = 1, end = 100000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (countTime(mid) - limit > 0) {
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return start;
    }

    public int solution(int[] pDiffs, int[] pTimes, long limit) {
        diffs = pDiffs;
        times = pTimes;

        return (binarySearch(limit));
    }
}
