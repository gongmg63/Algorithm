import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] cut = new int[commands[i][1]-commands[i][0] + 1];
            for(int j = commands[i][0]-1,index = 0; j < commands[i][1]; j++,index++){
                cut[index] = array[j];
            }
            Arrays.sort(cut);
            answer[i] = cut[commands[i][2]-1];
        }
        return answer;
    }
}