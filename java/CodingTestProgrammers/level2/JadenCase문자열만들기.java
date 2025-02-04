package level2;

import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s," ",true);
        ArrayList<String> arr = new ArrayList<>();
        while(st.hasMoreTokens())
            arr.add(st.nextToken());
        for(int i = 0; i < arr.size(); i++){
            if(!Character.isDigit(arr.get(i).charAt(0)) ){
                answer+=Character.toUpperCase(arr.get(i).charAt(0));
                if(arr.get(i).length() > 1)
                    answer+=arr.get(i).substring(1);
            }
            else{
                answer+=arr.get(i);
            }
        }
        return answer;
    }
}
public class JadenCase문자열만들기 {
    
}
