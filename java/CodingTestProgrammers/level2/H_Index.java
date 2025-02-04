package level2;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int[] thesis = new int[citations.length];
        for(int i = 0; i < citations.length; i++)
            thesis[i] = citations[citations.length - 1 -i];
        int h = 0;
        for(int i = 0; i < citations.length; i++){
            if(i+1 <= thesis[i])
                h=i+1;
        }
        return h;
    }
}
public class H_Index {
    
}
