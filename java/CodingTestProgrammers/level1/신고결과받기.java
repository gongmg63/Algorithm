package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,ArrayList> map = new HashMap<>();
        HashMap<String,Integer> id_index = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        Arrays.sort(report);
        for(String i:report)
            arr.add(i);
        for(int i=0;i < arr.size()-1; i++){
            if(arr.get(i).equals(arr.get(i+1))){
                arr.remove(i);
                i--;
            }
        }
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i],new ArrayList<>());
            id_index.put(id_list[i],i);
        }
        for(int j = 0; j < arr.size(); j++){
                String[] sp = arr.get(j).split(" ");
                map.get(sp[1]).add(sp[0]);
        }
        for(int i = 0; i < id_list.length; i++){
            if(map.get(id_list[i]).size() >= k){
                for(int j = 0; j < map.get(id_list[i]).size(); j++){
                    answer[id_index.get(map.get(id_list[i]).get(j))]++;
                }
            }
        }
        return answer;
    }
}