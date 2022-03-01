package level2;

class Solution {
    int solution(int[][] land) {
        int max = 0;
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                max = 0;
                for(int k = 0; k < land[0].length; k++){
                    if(j!=k && max < land[i-1][k])
                            max = land[i-1][k];
                }
                land[i][j] += max;
            }
        }
        return Math.max(Math.max(land[land.length-1][0],land[land.length-1][1]),Math.max(land[land.length-1][2],land[land.length-1][3]));
    }
}

public class 땅따먹기 {
    
}
