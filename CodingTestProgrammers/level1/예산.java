class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        for(int i = 0; i < d.length-1; i++) {
        	for(int j = i+1; j < d.length; j++) {
        		if(d[i]>d[j]) {
        			int tmp = d[i];
        			d[i] = d[j];
        			d[j] = tmp;
        		}
        	}
        }
        for(int i = 0 ; i < d.length; i++) {
        	if(budget >= d[i]) {
        		budget -= d[i];
        		answer++;
        	}
        }
        return answer;
    }
}