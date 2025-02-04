import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] fail = new double[N];
        double[] hum = new double[N+1];
        for(int i = 1; i < N+1; i++)
        	answer[i-1] = i;
        for(int i = 1;i <= N+1; i++) {
        	int num = 0;
        	for(int j = 0;j < stages.length; j++) {
        		if(stages[j]==i)
        			num++;
        	}
        	hum[i-1] = num;
        }
        for(int i = 0; i < N; i++) {
        	double humsum = 0;
        	for(int j=i;j < N+1;j++) {
        		humsum += hum[j];
        	}
        	if(hum[i]!=0)
        		fail[i] = hum[i]/humsum;
        	else
        		fail[i] = 0;
        }
        for(int i = 0; i < N-1;i++) {
        	for(int j = 0; j < N - i - 1; j++) {
        		if(fail[j] < fail[j+1]) {
        			double tmp = fail[j];
        			fail[j] = fail[j+1];
        			fail[j+1] = tmp;
        			int tmp2 = answer[j];
        			answer[j] = answer[j+1];
        			answer[j+1] = tmp2;
        		}
        	}
        }
        return answer;
    }
}