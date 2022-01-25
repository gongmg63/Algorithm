class Solution {
    public int solution(int n) {
        int answer = 0;
        int m = n;
        int x = 1;
        if (n == 1)
            answer = 1;
        while(x <= n/2) {
            if(n%x==0){
                answer += x + m;
                m = n%x;
            }
            x++;
        }
        return answer;
    }
}