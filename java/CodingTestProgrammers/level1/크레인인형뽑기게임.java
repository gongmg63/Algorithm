package level1;

import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> boom = new ArrayList<>();
        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i]-1] != 0){
                    boom.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }

            }
        }
        if(boom.size() > 1){
            for(int k = 1; k < boom.size(); k++){
                if(boom.get(k) == boom.get(k-1)){
                    answer+=2;
                    boom.remove(k);
                    boom.remove(k-1);
                    k=0;
                }
            }
        }
        return answer;
    }
}