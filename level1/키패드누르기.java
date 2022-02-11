package level1;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        ArrayList<Integer> leftkey = new ArrayList<Integer>(Arrays.asList(1,4,7,10));
        ArrayList<Integer> rightkey = new ArrayList<Integer>(Arrays.asList(3,6,9,15));
        ArrayList<Integer> centerkey = new ArrayList<Integer>(Arrays.asList(2,5,8,0));
        int presentlefthand = 10;
        int presentrighthand = 15;
        for(int i=0; i < numbers.length; i++){
            if(leftkey.contains(numbers[i])){
                answer+="L";
                presentlefthand = numbers[i];
            }
            else if(rightkey.contains(numbers[i])){
                answer+="R";
                presentrighthand = numbers[i];
            }
            else{
                if(i > 0){
                    if(Math.abs(leftkey.indexOf(presentlefthand)-centerkey.indexOf(numbers[i])) > Math.abs(rightkey.indexOf(presentrighthand)-centerkey.indexOf(numbers[i]))){
                        answer+="R";
                        presentrighthand = numbers[i];
                    }
                    else if (Math.abs(leftkey.indexOf(presentlefthand)-centerkey.indexOf(numbers[i])) < Math.abs(rightkey.indexOf(presentrighthand)-centerkey.indexOf(numbers[i]))){
                        answer+="L";
                        presentlefthand = numbers[i];
                    }
                    else
                        answer += String.valueOf(Character.toUpperCase(hand.charAt(0)));
                }
                else
                    answer += String.valueOf(Character.toUpperCase(hand.charAt(0)));
            }
        }
        return answer;
    }
}
public class 키패드누르기 {
    
}
