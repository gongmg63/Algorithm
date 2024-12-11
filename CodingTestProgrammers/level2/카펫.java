package level2;


class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int x = 3; x <= brown+yellow; x++){
            for(int y = 3; y <= brown+yellow; y++){
                if(2*x+2*y-4== brown && (y-2)*(x-2)==yellow){
                    answer[0]=x;
                    answer[1]=y;
                }
                if(x*y > brown+yellow)
                    break;
            }
        }
        return answer;
    }
}
public class 카펫 {
    
}
