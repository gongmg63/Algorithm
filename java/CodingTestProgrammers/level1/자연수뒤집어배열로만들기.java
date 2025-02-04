class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        StringBuffer  sb = new StringBuffer(s);
        int[] answer = new int[s.length()];
        
        sb.reverse();
        s = sb.toString();
        for(int i = 0; i < s.length() ; i++){
            answer[i] = Character.getNumericValue(s.charAt(i));
        }
        return answer;
    }
}