package level2;

public class 광물캐기 {
    int[] picks;
    String[] minerals;
    int answer = Integer.MAX_VALUE;

    void fun(int mineralIdx, int fatigue) {
        if (mineralIdx == minerals.length || picks[0] + picks[1] + picks[2] == 0) {
            answer = Integer.min(answer, fatigue);
            return ;
        }

        for (int j = 0; j < 3; ++j) {
            int pFatigue = 0;
            int i = mineralIdx;

            if (picks[j] != 0) {
                for (; i < minerals.length && i - mineralIdx < 5; ++i) {
                    if (j == 0)
                        ++pFatigue;
                    else if (j == 1) {
                        if (minerals[i].equals("diamond"))
                            pFatigue += 5;
                        else
                            ++pFatigue;
                    }
                    else {
                        if (minerals[i].equals("diamond"))
                            pFatigue += 25;
                        else if (minerals[i].equals("iron"))
                            pFatigue += 5;
                        else
                            ++pFatigue;
                    }
                }

                fatigue += pFatigue;
                --picks[j];
                fun(i, fatigue);
                ++picks[j];
                fatigue -= pFatigue;
            }
        }
    }

    public int solution(int[] localPicks, String[] localMinerals) {
        picks = localPicks;
        minerals = localMinerals;

        fun(0, 0);

        return answer;
    }
}
