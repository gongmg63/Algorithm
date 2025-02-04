class Solution {
    public boolean solution(String s) {
        char[] arr = s.toCharArray();
        if (arr.length ==4 || arr.length ==6) {
            for(char i:arr) {
                if(i<48 || i>57 )
                    return false;
            }
        }
        else
            return false;
        return true;
    }
}