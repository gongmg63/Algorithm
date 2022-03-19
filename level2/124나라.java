package level2;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while(n > 3){
            sb.append(n%3);
            n = n/3;
        }
        
        return answer;
    }
}
public class 124나라 {
    
}
