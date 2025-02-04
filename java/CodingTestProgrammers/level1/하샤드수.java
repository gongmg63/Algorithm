class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String sx = Integer.toString(x);
        int sum = 0; 
        for(int i = 0; i < sx.length(); i++){
            sum += Character.getNumericValue(sx.charAt(i));;
        }
        if (x%sum==0)
            answer = true;
        else
            answer = false;
        return answer;
    }
}