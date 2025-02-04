import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                answer.add(arr[i]);
            }
        }
        if(answer.size()==0)
            answer.add(-1);
        else{
            for (int i =0;i<answer.size();i++){
                for(int j=i+1;j<answer.size();j++){
                    if(answer.get(i) > answer.get(j)){
                        int temp = answer.get(i);
                        answer.set(i,answer.get(j));
                        answer.set(j,temp);
                    }      
                }
            }   
        }
        return answer;
    }
}