package level2;

import java.util.ArrayList;

public class 우박수열정적분 {
    class Pair {
        public int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<Pair> point = new ArrayList<>();
    ArrayList<Double> area = new ArrayList<>();

    void hailstoneSequence(int k) {
        int x = 0;

        point.add(new Pair(x, k));

        while (k > 1) {
            if (k % 2 == 0)
                k /= 2;
            else
                k *= 3 + 1;
            point.add(new Pair(++x, k));
        }
    }

    void getAllArea() {
        Pair p1 = point.get(0);
        Pair p2;

        for (int i = 1; i < point.size(); ++i) {
            p2 = point.get(i);
            area.add((double)Math.abs(p1.y - p2.y) / 2 + Math.min(p1.y, p2.y));
            p1 = p2;
        }
    }

    double getArea(int[] range) {
        double ret = 0;
        int start = range[0];
        int end = point.size() - 1 + range[1];

        if (end < start)
            return -1;
        for (int i = start; i < end; ++i)
            ret += area.get(i);
        return ret;
    }

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        hailstoneSequence(k);
        getAllArea();
        for (int i = 0; i < ranges.length; ++i)
            answer[i] = getArea(ranges[i]);
        return answer;
    }
}
