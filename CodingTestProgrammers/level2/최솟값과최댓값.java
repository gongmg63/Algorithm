package level2;

class Solution {
    public String solution(String s) { 
         String[] arr = s.split("\\s+");
         int max = Integer.parseInt(arr[0]);
         int min = Integer.parseInt(arr[0]);
         for(int i = 0; i < arr.length; i++){
            if(max <= Integer.parseInt(arr[i]))
                max = Integer.parseInt(arr[i]);
            if(min >= Integer.parseInt(arr[i]))
                min = Integer.parseInt(arr[i]);
         }
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}
public class 최솟값과최댓값 {
    
}
