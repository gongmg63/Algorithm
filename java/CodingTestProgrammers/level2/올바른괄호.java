package level2;

class Solution {
    boolean solution(String s) {
        int left = 0;
        int right = 0;
        if(s.charAt(0)!='(' || s.charAt(s.length()-1)!=')'|| s.replace(")", "").length() != s.replace("(", "").length())
            return false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(')
                left++;
            else if(s.charAt(i)==')')
                right++;
            if(left < right)
                return false;
        }
        return true;
    }
}

public class 올바른괄호 {
    
}
