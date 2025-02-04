package level2;

import java.util.*;

public class 과제진행하기 {
    class Pair {
        String name;
        int time;

        Pair(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    int calTime(String pre, String next) {
        StringTokenizer preSt = new StringTokenizer(pre, ":");
        StringTokenizer nextSt = new StringTokenizer(next, ":");

        int preMinute = Integer.parseInt(preSt.nextToken()) * 60 + Integer.parseInt(preSt.nextToken());
        int nextMinute = Integer.parseInt(nextSt.nextToken()) * 60 + Integer.parseInt(nextSt.nextToken());

        return nextMinute - preMinute;
    }

    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String[]> plansList = new ArrayList<>(Arrays.asList(plans));
        Stack<Pair> st = new Stack<>();


        plansList.sort(Comparator.comparing(a -> a[1]));
        String[] pre = plansList.get(0);
        for (int i = 1; i < plansList.size(); ++i) {
            String[] next = plansList.get(i);

            int workTime = Integer.parseInt(pre[2]);
            int betweenTime = calTime(pre[1], next[1]);

            if (betweenTime < workTime)
                st.add(new Pair(pre[0], workTime - betweenTime));
            else {
                answer.add(pre[0]);
                betweenTime -= workTime;
                while (!st.empty() && betweenTime > 0) {
                    Pair yetWork = st.pop();

                    if (betweenTime < yetWork.time) {
                        yetWork.time -= betweenTime;
                        betweenTime = 0;
                        st.add(yetWork);
                    } else {
                        answer.add(yetWork.name);
                        betweenTime -= yetWork.time;
                    }
                }
            }
            pre = next;
            if (i == plansList.size() - 1)
                answer.add(next[0]);
        }
        while (!st.empty())
            answer.add(st.pop().name);

        String[] ret = new String[answer.size()];
        for (int i = 0; i < answer.size(); ++i)
            ret[i] = answer.get(i);

        return ret;
    }
}
