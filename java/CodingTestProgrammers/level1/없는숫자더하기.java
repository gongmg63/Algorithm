package level1;

import java.util.ArrayList;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> number = new ArrayList<Integer>();
        for(int i: numbers)
            number.add(i);
        for(int i = 1 ; i < 10; i++){
            if(!number.contains(i))
                answer += i;
        }
        return answer;
    }
}