package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 수식최대화 {
    long calExpression(String expression, ArrayList<Character> oper) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<Long> numList = new LinkedList<>();
        List<Character> operList = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (oper.contains(str.charAt(0)))
                operList.add(str.charAt(0));
            else
                numList.add(Long.parseLong(str));
        }

        for (char presentOper : oper) {
            for (int j = 0; j < operList.size(); ++j) {
                if (operList.get(j) == presentOper) {
                    long left = numList.remove(j);
                    long right = numList.remove(j);
                    long ret;

                    if (presentOper == '+')
                        ret = left + right;
                    else if (presentOper == '-')
                        ret = left - right;
                    else
                        ret = left * right;
                    numList.add(j, ret);
                    operList.remove(j--);
                }
            }
        }
        return Math.abs(numList.get(0));
    }

    public long solution(String expression) {
        long answer = 0;
        char[][] operArr = {{'+', '-', '*'},{'+', '*', '-'},{'-', '+', '*'},
                {'-', '*', '+'},{'*', '+', '-'},{'*', '-', '+'}};

        for (int i = 0; i < 6; ++i) {
            ArrayList<Character> operList = new ArrayList<>();
            operList.add(operArr[i][0]);
            operList.add(operArr[i][1]);
            operList.add(operArr[i][2]);

            answer = Math.max(answer, calExpression(expression, operList));
        }

        return answer;
    }
}
