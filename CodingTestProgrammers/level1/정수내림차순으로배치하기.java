import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String answer = "";
        long[] arr = new long[String.valueOf(n).length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = n%10;
            n/=10;
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--){
            answer +=String.valueOf(arr[i]);
        }
        return Long.parseLong(answer);
    }
}