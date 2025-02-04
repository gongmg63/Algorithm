class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        int p=0;
        int y=0;
        for(char a:arr){
            if(a == 'p' || a=='P')
                p++;
            else if(a=='y' || a=='Y')
                y++;
        }
        if(p!=y)
            return false;
        return answer;
    }
}