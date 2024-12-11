package level2;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < bridge_length; i++)
            q.add(0);
        while(!q.isEmpty()){
            if(weight >= truck_weights[index]){
                answer++;
                weight += q.poll();
                q.add(truck_weights[index]);
                weight -= truck_weights[index];
                index++;
            }
            else{
                while(weight < truck_weights[index]){
                    weight += q.poll();
                    if(weight >= truck_weights[index]){
                        q.add(truck_weights[index]);
                    }
                    else{
                        q.add(0);
                    }
                    answer++;
                }
                weight -= truck_weights[index];
                index++;
            }
            if(index == truck_weights.length){
                while(!q.isEmpty()){
                    answer++;
                    q.poll();
                }
            }
        }
        return answer;
    }
}
public class 다리를지나는트럭 {
    
}
