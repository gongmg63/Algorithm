package level1;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int prime = nums[i] + nums[j] + nums[k];
                    int check = 0;
                    for(int l = 2;l*l <= prime; l++){
                        if(prime%l == 0)
                            check++;
                    }
                    if(check == 0)
                        answer++;
                }
            }
        }
        return answer;
    }
}