package level1;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int rank = 7;
        int zero = 0;
        ArrayList<Integer> lottosAr = new ArrayList<>();
        for(int i:lottos)
            lottosAr.add(i);
        for(int i = 0; i < win_nums.length;i++){
            if(lottosAr.contains(win_nums[i]))
                rank--;
            if(lottosAr.get(i)==0)
                zero++;
        }
        if(rank == 7){
            if(zero == 0){
                answer[0] = 6;
                answer[1] = 6;
            }
            else{
                answer[0] = rank-zero;
                answer[1] = 6;
            }
        }
        else{
            answer[0] = rank-zero;
            answer[1] = rank;
        }
        return answer;
    }
}