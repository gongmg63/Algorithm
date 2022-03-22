package level2;

class Solution {
    public String solution(int n) {
        String answer = "";
        int i = 3;
        StringBuilder number = new StringBuilder();
        StringBuilder minus = new StringBuilder();
        while(n > 0){
            n = n - i;
            i *= 3;
            number.append(3);
        }
        n = Math.abs(n);
        if(n==0)
            minus.append(0);
        else{
            while(n != 0){
                minus.append(n%3);
                n /= 3;
            }
            minus = minus.reverse();
        }
        Long num = Long.parseLong(number.toString());
        Long minu = Long.parseLong(minus.toString());

        return answer = String.valueOf(num-minu).replaceAll("3", "4");
    }
}
public class 124나라 {
    
}
