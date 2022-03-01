package level2;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        ArrayList<Integer> people_arraylist = new ArrayList<>();
        for(int i = 0; i < people.length; i++)
            people_arraylist.add(people[i]);
        while(people_arraylist.size()>0){
            if(people_arraylist.size()>1){
                if(people_arraylist.get(people_arraylist.size()-1) + people_arraylist.get(0) <= limit){
                    people_arraylist.remove(people_arraylist.size()-1);
                    people_arraylist.remove(0);
                }
                else{
                    people_arraylist.remove(people_arraylist.size()-1);
                }
            }
            else{
                people_arraylist.remove(people_arraylist.size()-1);
            }
            answer++;
        }
        return answer;
    }
}
public class 구명보트 {
    
}
