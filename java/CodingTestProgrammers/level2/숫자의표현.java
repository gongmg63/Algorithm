package level2;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int j = 2;
        for(int i = 1; i <= n; i++){
            sum += i;
            if(sum == n) {
                answer++;
                sum = 0;
                i = j;
                j++;
            }
            else if(sum > n){
                sum = 0;
                i = j;
                j++;
            }
        }
        return answer;
    }
}
public class 숫자의표현 {
    
}
