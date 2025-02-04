import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        Calendar day = Calendar.getInstance();
        day.clear();
        day.set(2016,a-1,b);
        int dayofweek = day.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1)
            return answer = "SUN";
        else if (dayofweek == 2)
            return answer = "MON";
        else if (dayofweek == 3)
            return answer = "TUE";
        else if (dayofweek == 4)
            return answer = "WED";
        else if (dayofweek == 5)
            return answer = "THU";
        else if (dayofweek == 6)
            return answer = "FRI";
        else
            return answer = "SAT";
    }
}