package level1;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] lefthand = {3,0};
        int[] righthand = {3,2};
        int[] input = {0,0};
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i]==0)
                numbers[i] = 11;
        }
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                lefthand[0] = (numbers[i]-1)/3;
                lefthand[1] = (numbers[i]-1)%3;
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                righthand[0] = (numbers[i]-1)/3;
                righthand[1] = (numbers[i]-1)%3;
            }
            else{
                input[0] = (numbers[i]-1)/3;
                input[1] = (numbers[i]-1)%3;
                int lcdif = Math.abs(input[0] - lefthand[0]) + Math.abs(input[1] - lefthand[1]);
                int rcdif = Math.abs(input[0] - righthand[0]) + Math.abs(input[1] - righthand[1]);
                if( lcdif > rcdif){
                    answer += "R";
                    righthand[0] = (numbers[i]-1)/3;
                    righthand[1] = (numbers[i]-1)%3;
                }
                else if(lcdif < rcdif){
                    answer += "L";
                    lefthand[0] = (numbers[i]-1)/3;
                    lefthand[1] = (numbers[i]-1)%3;
                }
                else{
                    answer += String.valueOf(Character.toUpperCase(hand.charAt(0)));
                    if(String.valueOf(Character.toUpperCase(hand.charAt(0))).equals("L")){
                        lefthand[0] = (numbers[i]-1)/3;
                        lefthand[1] = (numbers[i]-1)%3;
                    }
                    else {
                        righthand[0] = (numbers[i]-1)/3;
                        righthand[1] = (numbers[i]-1)%3;
                    }
                }
            }
        }
        return answer;
    }
}
public class 키패드누르기 {
    
}
