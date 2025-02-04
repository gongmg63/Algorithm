import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        ArrayList<Integer> reserve2 = new ArrayList<>();
        ArrayList<Integer> lost2 = new ArrayList<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i:lost)
            lost2.add(i);
        for(int i:reserve)
            reserve2.add(i);
        for(int i =0; i < lost2.size(); i++){
            if(reserve2.contains(lost2.get(i))){
                reserve2.remove(lost2.get(i));
                lost2.remove(lost2.get(i));
                answer++;
                i--;
            }
        }
        for(int i : lost2){
            for(int j = 0; j < reserve2.size();j++){
                if(i+1 == reserve2.get(j) || i-1 == reserve2.get(j)){
                    reserve2.remove(reserve2.get(j));
                    answer++;
                }
            }
        }
        return answer;
    }
}