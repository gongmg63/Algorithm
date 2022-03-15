package level2;

import java.util.ArrayList;

class Solution {
    public int solution(String name) {
        ArrayList<Integer> updown = new ArrayList<>();
        int answer = 0;
        int answerre = 0;
        for(int i = 0; i < name.length(); i++){
            updown.add((int)name.charAt(i) - 65);
            if(updown.get(i)>13){
                updown.remove(i);
                updown.add(91-(int)name.charAt(i));
            }
            answer+=updown.get(i);
        }
        answerre = answer;
        int previous = 0;
        for(int i = 0; i < updown.size(); i++){
            if(updown.get(i)!=0){
                int front =  i - previous;
                int back = previous + updown.size() - i;
                if(front > back){
                    answer += back;
                }
                else{
                    answer += front;
                }
                previous = i;
            }
        }
        previous = updown.size()-1;
        for(int i = updown.size()-1; i > 0; i--){
            if(updown.get(i)!=0){
                int front =  previous - i;
                int back = updown.size()-previous + i;
                if(front > back){
                    answerre += back;
                }
                else{
                    answerre += front;
                }
                previous = i;
            }
        }
        if(answer < answerre+1)
            return answer;
        else
            return answerre+1;
    }
}
public class 조이스틱 {
    
}
