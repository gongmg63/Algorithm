package level2;

class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int sum = 0;
        if(board.length < 2 || board[0].length < 2){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    sum += board[i][j];
                }
            }
            if(sum==0)
                return 0;
            else
                return 1;
        }
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                if( board[i][j] != 0)
                    board[i][j] = Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
                if(board[i][j] > answer)
                    answer = board[i][j];
            }
        }
        return answer*answer;
    }
}
public class 가장큰정사각형찾기 {
    
}
