class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[][] min = {{0,0}};
        for(int i = 0; i < sizes.length; i++) {
        	for(int j = 0;j < sizes[i].length;j++) {
                if(sizes[i][0] < sizes[i][1]){
                    int tmp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }
        		if(min[0][j] < sizes[i][j])
        			min[0][j] = sizes[i][j];
        	}
        }
        return answer = min[0][0]*min[0][1];
    }
}