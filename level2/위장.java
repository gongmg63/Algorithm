package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        if(clothes.length == 1){
            return answer;
        }
        HashMap<String,ArrayList> ot = new HashMap<>();
        String[] otkind = new String[clothes.length];
        for(int i=0; i < clothes.length; i++){
            otkind[i] = clothes[i][1];
        }
        Arrays.sort(otkind);
        for(int i =0 ; i < otkind.length-1;i++){
            if(otkind[i]!=otkind[i+1]){
                ot.put(otkind[i],new ArrayList<>());
                if(i+1==otkind.length-1){
                    ot.put(otkind[i+1],new ArrayList<>());
                }
            }
        }
        for(int i = 0; i < clothes.length; i++){
            ot.get(clothes[i][1]).add(clothes[i][0]);
        }
        ArrayList<Integer> otnumber = new ArrayList<>();
        for(String key:ot.keySet()){
            otnumber.add(ot.get(key).size());
        }
        for(int j = 0; j < otnumber.size(); j++){
            answer *= (otnumber.get(j)+1);
        }
        return answer -1;
    }
}
public class 위장 {
    
}
