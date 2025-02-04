class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double a = arr.length;
        double sum = 0;
        for(int i = 0; i < a; i++)
            sum += arr[i];
        answer = sum / a;
        return answer;
    }
}