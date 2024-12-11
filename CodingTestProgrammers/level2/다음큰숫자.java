package level2;

class Solution {
    public int solution(int n) {
        int answer = n+1;
        String binary = Integer.toBinaryString(n);
        int one = binary.length() - binary.replace("1", "").length();
        String ansbinary = Integer.toBinaryString(answer);
        int ansone = ansbinary.length() - ansbinary.replace("1", "").length();
        while(true){
            if(ansone == one)
                break;
            else{
                answer++;
                ansbinary = Integer.toBinaryString(answer);
                ansone = ansbinary.length() - ansbinary.replace("1", "").length();
            }
        }
        return answer;
    }
}

public class 다음큰숫자 {
    
}
