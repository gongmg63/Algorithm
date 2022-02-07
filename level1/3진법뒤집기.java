class Solution {
    public long solution(int n) {
        long answer = 0;
        int ind = 0;
        String three = "";
        while(n != 0) {
        	three += String.valueOf(n%3);
        	n /= 3;
        }
        for(int i = three.length()-1; i >= 0; i--) {
        	answer += Character.getNumericValue(three.charAt(i))*Math.pow(3,ind);
        	ind++;
        }
        return answer;
    }
}