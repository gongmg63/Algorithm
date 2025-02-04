package level2;

import java.util.Arrays;

class Solution {
    int prime(int n){
        for(int i = 2; i*i < n; i++){
            if(n % i == 0){
                return 0;
            }
        }
        return 1;
    }
    public int solution(String numbers) {
        int answer = 0;
        String[] nums = new String[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            nums[i] = String.valueOf(numbers.charAt(i));
        }
        Arrays.sort(nums);
        int num = 0;
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = 1; j <= nums.length; j++){
                
            }
        }
        return answer;
    }
}

public class 소수찾기 {
    
}