package level1;

import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length-1];
        for(int i = 0; i < arr.length; i++){
           if(answer%arr[i] != 0){
               answer += arr[arr.length - 1];
               i=0;
           }
        }
        return answer;
    }
}