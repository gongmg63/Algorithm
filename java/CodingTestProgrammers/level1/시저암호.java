import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        List<Integer> list = s.chars().boxed().collect(Collectors.toList());
        for(int i:list){
            if (i>=65 && i<=90){
                i+=n;
                if(i > 90)
                    i -=26;
            }
            else if (i>=97 && i<=122){
                i+=n;
                if(i>122)
                    i-=26;
            }
            answer += String.valueOf((char)i);
        }
        return answer;
    }
}