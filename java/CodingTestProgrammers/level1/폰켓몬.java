import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int kind=1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
        	if(nums[i] != nums[i+1])
        		kind++;
        }
        if(kind <= nums.length/2)
        	return answer = kind;
        else
        	return answer = nums.length/2;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,3,3,4};
        System.out.println(s.solution(nums));
    }
}