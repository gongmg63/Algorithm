class Solution {
    public int solution(int n) {
        int number1 = 0;
        int number2 = 1;
        int number3 = 0;
        for(int i = 1; i < n; i++){
            number3 = number1 + number2;
            number1 = number2%1234567;
            number2 = number3%1234567;
        }
        return number3%1234567;
    }
}