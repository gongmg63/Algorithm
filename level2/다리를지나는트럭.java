package level2;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int truck_length = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(truck_weights[0]);
        answer++;
        weight -= truck_weights[0];
        for(int i = 1; i < truck_weights.length; i++){
            if(weight - truck_weights[i] >= 0 && truck_length<bridge_length){
                answer++;
                truck_length++;
                queue.add(truck_weights[i]);
                weight -= truck_weights[i];
            }
            else if(weight - truck_weights[i] < 0 || truck_length==bridge_length ||i==truck_weights.length){
                weight += queue.poll();
                answer += bridge_length-truck_length;
                answer++;
                truck_length--;
            }
        }
        while(!queue.isEmpty()){
            answer++;
            queue.poll();
        }
        return answer;
    }
}
public class 다리를지나는트럭 {
    
}
