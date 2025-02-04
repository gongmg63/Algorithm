class Solution {
    public long solution(long n) {
        long answer = 0;
        if (n%2 == 0 ) {
            long i = 2;
            while(answer == 0 && i*i<= n){
                if (i*i == n)
                    return answer = (i+1)*(i+1);
                i+=2;
            }
        }
        else {
            long i = 1;
            while(answer==0 && i*i <= n){
                if(i*i == n)
                    return answer = (i+1)*(i+1);
                i+=2;
            }
        }
        return -1;
    }
}